import ctypes
class d_array(object):

    def __init__(self):
        self.n = 0
        self.cap = 1
        self.A = self.create_array(self.cap)

    def __len__(self):
        return self.n

    def __getitem__(self, k): 
        if not 0 <= k <self.n: 
            return IndexError('K is out of bounds !') 
        return self.A[k]

    def append(self, ele):
        if self.n == self.cap:
            self.resize_array(2 * self.cap)
        self.A[self.n] = ele
        self.n += 1

    def delete(self): 
 
        if self.n==0: 
            print("Array is empty deletion not Possible") 
            return
         
        self.A[self.n-1]=0
        self.n-=1

    def create_array(self, new_cap): 
        return (new_cap * ctypes.py_object)()

    def resize_array(self, new_cap): 
        B = self.create_array(new_cap) 
         
        for k in range(self.n):  
            B[k] = self.A[k] 
             
        self.A = B 
        self.cap = new_cap

arr = d_array()
arr.append(5)
arr.append(6)
arr.append(7)
print(len(arr))

arr.delete()
print(len(arr))
