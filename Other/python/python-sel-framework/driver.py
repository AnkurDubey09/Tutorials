from selenium import webdriver

class Driver:

    def __init__(self, browser_name):
        if browser_name == "chrome":
            self.driver_instance = webdriver.Chrome()
        elif browser_name == "firefox":
            self.driver_instance = webdriver.Firefox()
        elif browser_name == "ie":
            self.driver_instance = webdriver.Ie()

    def navigate_to(self, url):
        if isinstance(url, str):
            self.driver_instance.get(url)
            self.driver_instance.set_page_load_timeout(20)