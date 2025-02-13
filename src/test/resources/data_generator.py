import csv
import random
from datetime import datetime, timedelta

people = [f'Person_{i}' for i in range(1, 31)]
start_date = datetime.now() - timedelta(days=30)
num_records_per_day = 10

with open('transactions.csv', mode='w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['From', 'To', 'Timestamp', 'Amount'])

    for day in range(30):
        current_date = start_date + timedelta(days=day)
        for _ in range(num_records_per_day):
            from_person = random.choice(people)
            to_person = random.choice(people)
            while to_person == from_person:
                to_person = random.choice(people)
            timestamp = current_date + timedelta(hours=random.randint(0, 23), minutes=random.randint(0, 59))
            amount = round(random.uniform(10.0, 1000.0), 2)
            writer.writerow([from_person, to_person, timestamp.strftime('%Y-%m-%d %H:%M:%S'), amount])