from test_base import Test_Base
import unittest
from selenium import webdriver
from page_objects import python_home_page_po


class python_org_test(Test_Base):

    def test_title(self):
        self.po = python_home_page_po(self.driver.driver_instance)
        self.assertIn ("Python", self.driver.driver_instance.title)
        self.po.news_link.click()
        self.po = python_home_page_po(self.driver.driver_instance) # again creating object to avoid stale element reference error, since page is refreshed on clicking news.
        self.assertIn("News", self.po.news_link_confirmation_text.text)
        #self.dri.save_screenshot("frm1.png")

    def test_navigation_on_navs(self):
        titleOnPage = ['about', 'downloads', 'doc', 'community', 'success-stories', 'blogs', 'events']
        self.po = python_home_page_po(self.driver.driver_instance)
        navs = self.po.get_nav_links()
        for i in range(len(navs)):
            self.po.get_nav_links()[i].click()
            self.assertIn(titleOnPage[i], self.driver.driver_instance.current_url)
            self.po = python_home_page_po(self.driver.driver_instance)

if __name__ == '__main__':
    unittest.main(verbosity=2)
        