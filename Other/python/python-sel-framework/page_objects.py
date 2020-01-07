from element_finder_util import Element_Finder
from locators_or import python_home_page_or as PH

class python_home_page_po():

    def __init__(self, driver):
        self.driver = driver
        self.ef = Element_Finder(self.driver)
        self.news_link = self.ef.get_locator(PH.news_links["how"], PH.news_links["value"])
        self.news_link_confirmation_text = self.ef.get_locator(PH.news_link_confirmation_text["how"], PH.news_link_confirmation_text["value"])

    def get_nav_links(self):
        return self.ef.get_locators(PH.all_nav_links["how"], PH.all_nav_links["value"])

class expedia_home_page_po:
    pass

class google_home_page_po:
    pass