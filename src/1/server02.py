import socket

TCP_IP = '127.0.0.1'
TCP_PORT = 15710

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((TCP_IP,TCP_PORT))

BUFFER1 = 1024
BUFFER2 = 1024
s.listen(2)
print("Socket is listening")

c1 , addr = s.accept()
print("First client connected : {}".format(addr))

while True:
    c2 ,addr2 = s.accept()
    print("second client connected:{}".format(addr2))

    x = c1.recv(BUFFER1)
    x = x.decode("utf-8")
    y = c2.recv(BUFFER2)
    y = y.decode("utf-8")
    if not x or not y:
        break
    z = int(x) + int(y)
    c1.sendall(str(z).encode("utf-8"))
    c2.sendall(str(z).encode("utf-8"))
    print("Data sent successfully")
    break
c1.close()