import Adafruit_DHT
import RPi.GPIO as GPIO
import time
import requests
 
sensor = Adafruit_DHT.DHT11
GPIO.setmode(GPIO.BOARD)

# sensor data pin
sensor_pin = 25

# url = 'http://httpbin.org/post'
url = 'http://ec2-34-230-73-23.compute-1.amazonaws.com:9090/home-temperature'
headers = {'Content-type': 'application/json'}

print("*** Reading temperature e humidity");

while(1):

    humidity, temperature = Adafruit_DHT.read_retry(sensor, sensor_pin);

    if humidity is not None and temperature is not None:
        data = "{\"temperature-celsius\":" + str(temperature) + ", \"humidity\":" + str(humidity) + "}"
        print(data)
        response = requests.post(url, data=data, headers=headers)
        if response.status_code == 200:
            print('Data posted')
        else:
            print('Error posting data: ' + response.text)
        time.sleep(60)
    else:
        print("Fail reading DHT11 sensor data!!!")
