# [12] XPATH를 이용하여 페이스북 로그인 하기

```python
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
import time

driver = webdriver.Chrome('/usr/local/Cellar/chromedriver/chromedriver')
driver.get('https://www.facebook.com/')

user_name = 'abcd@yopmail.com'
password = 'asdf1234'

email_id = "//*[@id='email']"
pwd_id = "//*[@id='pass']"
login_btn = "//*[@id='u_0_e']"

email_tag = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, email_id)))
password_tag = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, pwd_id)))
login_button_tag = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, login_btn)))

email_tag.clear()
email_tag.send_keys(user_name)

password_tag.clear()
password_tag.send_keys(password)

login_button_tag.click()

time.sleep(5)

driver.quit()
```

