class User(object):
	def factory(type):
		if type == "Student":
			return Student()
		if type == "Teacher":
			return Teacher()
		raise AssertionError("User creation error: " + type)
	
	factory = staticmethod(factory)

class Student(User):
	def login(self):
		print("Student logged in.")

class Teacher(User):
	def login(self):
		print("Teacher logged in.")
		
## Creating object using factory:
objStudent = User.factory("Student")
objStudent.login()

objTeacher = User.factory("Teacher")
objTeacher.login()
