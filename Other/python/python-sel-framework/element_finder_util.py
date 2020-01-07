from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from test_base import Test_Base

class Element_Finder:

    def __init__(self, driver):
        self.driver = driver

    def get_locator(self, how, value):
        
        if how == "CSS":
            return WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((
                By.CSS_SELECTOR, value))) 
            
        elif how == "XPATH":
            return WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((
                By.XPATH, value)))
            
        elif how == "ID":
            return WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((
                By.ID, value)))
           
        elif how == "NAME":
            return WebDriverWait(self.driver, 10).until(
            EC.visibility_of_element_located((
                By.NAME, value))) 
                    
    
    def get_locators(self, how, value):

        self.elems = []
        
        if how == "CSS":
            self.elems = self.driver.find_elements(By.CSS_SELECTOR, value)
        elif how == "XPATH":
            self.elems = self.driver.find_elements(By.XPATH, value)
        elif how == "ID":
            self.elems = self.driver.find_elements(By.ID, value)
        elif how == "NAME":
            self.elems = self.driver.find_elements(By.NAME, value)
        return self.elems

    def get_how_to_find(self, how):
        return how.split('_')[-1]