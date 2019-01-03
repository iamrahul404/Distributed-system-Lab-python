import socket
import random
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
TCP_IP = '127.0.0.1'
port = 15710
s.connect((TCP_IP,port))
BUFFER = 1024
x = 2
print(x)
s.sendall(str(x).encode("utf-8"))
#waiting for message
while True:
    data = s.recv(BUFFER)
    if data:
        break
x = data.decode("utf-8")
print("received sum is = {}".format(x))
s.close()
