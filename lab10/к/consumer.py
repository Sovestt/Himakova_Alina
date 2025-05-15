import uuid
from kafka import KafkaConsumer, KafkaProducer
import mysql.connector
import json
from collections import Counter

# Подключение к MySQL
conn = mysql.connector.connect(host="localhost", user="user", password="password", database="mydb")
cursor = conn.cursor()

# Функция сохранения сообщений в базу
def save_to_db(message):
    data = json.dumps(message)
    cursor.execute("INSERT INTO user_actions (data) VALUES (%s)", (data,))
    conn.commit()

