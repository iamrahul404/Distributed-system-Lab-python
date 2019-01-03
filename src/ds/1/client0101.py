import socket
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
TCP_IP = '127.0.0.1'
port = 15710
s.connect((TCP_IP,port))
BUFFER = 1024
#waiting for message
while True:
    data = s.recv(BUFFER)
    if data:
        break
x = data.decode("utf-8")
print("RECEived data {}".format(x))
n = data.__len__()
s.send(str(n).encode("utf-8"))
while True:
    data = s.recv(BUFFER)
    if data:
        break
x = data.decode("utf-8")
print(x)
s.close()

