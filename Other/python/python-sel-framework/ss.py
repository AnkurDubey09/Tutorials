
class Animal:
    def __init__(self, breed):
        self.breed = breed
        if self.breed == "Dog":
            print('Bow Bow!!!')
        elif self.breed == "Cat":
            print('Meow Meow!!!')
        else:
            print("??????")

    def __str__(self):
        return f"{self.breed}"

class Dog(Animal):
    def __init__(self):
        Animal.__init__(self, "Dog")
        print("Dog created!")

d = Dog()
print(d)
d.breed = "Cat"
print(d)