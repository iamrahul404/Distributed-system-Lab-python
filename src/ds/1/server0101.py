import socket

TCP_IP = '127.0.0.1'
TCP_PORT = 15710

s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((TCP_IP,TCP_PORT))

BUFFER = 1024

s.listen(1)
print("Socket is listening")

c , addr = s.accept()
print("Connection Addr : {}".format(addr))

seq = "this_is_distributed_lab_assignment_done_by_rahul"
c.sendall(seq.encode("utf-8"))
l = seq.__len__()
# now wait for the msg
while True:
    data = c.recv(BUFFER)
    if not data:
        break
    x = data.decode("utf-8")
    print("length of the string sent is {}".format(x))
    x = int(x)
    msg = "Correct"
    if x is l:
        msg = "Correct"
    else:
        msg = "Incorrect"
    c.sendall(msg.encode("utf-8"))
    break
c.close()
