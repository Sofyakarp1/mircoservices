from aiogram import types, executor, Dispatcher, Bot
import requests
import json
import re
#from config import TOKEN

TOKEN = '1195701517:AAG13ombK3bjk2Cxn7uUho4S1z35ERwMeEc'
bot = Bot(token=TOKEN)
dp = Dispatcher(bot)

ip = "192.168.1.66"
all_url = f"http://{ip}:8444/all/employee"
holiday_url = f"http://{ip}:8444/all/vacations"
staff_url = f"http://{ip}:8444/get/employee"
phone_url = f"http://{ip}:8444/employee/phone/byName"
workspace_url = f"http://{ip}:8444/work/space"
email_url = f"http://{ip}:8444/work/email"

name_pattern = r'\w+'
staff_pattern = r'Staff \w+'
def data_recieving(url):
    response = requests.get(url)

    my_bytes_value = response.content

    my_json = my_bytes_value.decode('utf8').replace("'", '"')
    # Load the JSON to a Python list & dump it back out as formatted JSON
    rc_data = json.loads(my_json)
    s = json.dumps(rc_data, indent=4, sort_keys=True)
    print(s)
    return rc_data

def data_id_recieving(url, body):
    response = requests.post(url, data = body)
    my_bytes_value = response.content
    my_json = my_bytes_value.decode('utf8').replace("'", '"')
    print(my_json)
    id_data = json.loads(my_json)
    return id_data

@dp.message_handler(commands=['start'])
async def start(message: types.Message):
    markup = types.InlineKeyboardMarkup(row_width=1)
    item_get_data = types.InlineKeyboardButton('Get information about all user',callback_data='get_data')
    relax_get_data = types.InlineKeyboardButton("Get information about staff's holidays",callback_data='get_holiday')

    markup.add(item_get_data,relax_get_data)

    await bot.send_message(message.chat.id,'The bot receives data about the person \n\n\n If you want to get info about specific person, use the following commands: \n - Staff <Name> \n - Phone <Name> <Auth id> \n - Workspace <Name> \n - Email <Name>', reply_markup=markup)


@dp.callback_query_handler(lambda call: True)
async def answer(call):
    if call.data == 'get_data':
        rc_data = data_recieving(all_url)
        for person in rc_data['Persons']:
            text = 'Name: {name} \n Age: {age} \n Address: {address} \n Profession: {profession} \n Phone: {phone} \n Email: {email} \n Workspace: {workspace}'.format(profession=person['profession'], name=person['name'], age=person['age'], address=person['address'], phone=person['phone'], email=person['email'], workspace=person['space'])
            await bot.send_message(call.message.chat.id, text)
    elif call.data == 'get_holiday':
        rc_data = data_recieving(holiday_url)
        for person in rc_data['Persons']:
            print(person)
            text = 'Name: {name} \n Holiday: {holiday}'.format(name=person['name'], holiday=person['vacation'])
            await bot.send_message(call.message.chat.id, text)

@dp.message_handler()
async def get_info(msg: types.Message):
    if 'Staff' in msg.text:
        result = re.findall(name_pattern, msg.text)
        body = '{"name":"' + result[-1] + '"}'
        id_data = data_id_recieving(staff_url, body)
        person = id_data['Persons']
        if len(id_data['Persons']) == 1:
            await bot.send_message(msg.from_user.id, 'Id not found')
        else:
            text = 'Name: {name} \n Age: {age} \n Address: {address} \n Profession: {profession} \n Phone: {phone} \n Email: {email} \n Workspace: {workspace}'.format(profession=person['profession'], name=person['name'], age=person['age'], address=person['address'], phone=person['phone'], email=person['email'], workspace=person['space'])
            await bot.send_message(msg.from_user.id, text)
    elif 'Phone' in msg.text:
        result = re.findall(name_pattern, msg.text)
        body = '{"name":"' + result[-2] + '", "auth":"' + result[-1] + '"}'
        id_data = data_id_recieving(phone_url, body)
        phone = id_data['phone']
        text = f'Phone: {phone}'
        await bot.send_message(msg.from_user.id, text)
    elif 'Workspace' in msg.text:
        result = re.findall(name_pattern, msg.text)
        body = '{"name":"' + result[-1] + '"}'
        id_data = data_id_recieving(workspace_url, body)
        workspace = id_data['space']
        text = f'Workspace: {workspace}'
        await bot.send_message(msg.from_user.id, text)
    elif 'Email' in msg.text:
        result = re.findall(name_pattern, msg.text)
        body = '{"name":"' + result[-1] + '"}'
        id_data = data_id_recieving(email_url, body)
        email = id_data['email']
        text = f'Workspace: {email}'
        await bot.send_message(msg.from_user.id, text)

executor.start_polling(dp)
