from driver import Driver
from properties import Properties
import unittest

class Test_Base(unittest.TestCase):  

    @classmethod
    def setUpClass(inst):
        print("\n********* setup before class **********")
        inst.prop = Properties()

    def setUp(self):
        print("\n========setup========")
        self.driver = Driver(self.prop.browser_name)
        self.driver.navigate_to(self.prop.base_url_python)
        self.driver.driver_instance.maximize_window()
        
    def tearDown(self):
        print("\n========teardown========")
        self.driver.driver_instance.close()

    @classmethod
    def tearDownClass(inst):
        print("\n********* after class **********")
        