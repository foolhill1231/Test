import requests
response = requests.get("https://review-of-my-life.blogspot.com/")
print (response.text)
html_doc = requests.get("https://review-of-my-life.blogspot.com").text
soup = BeautifulSoup(html_doc, 'html.parser') # BeautifulSoupの初期化
print(soup.prettify())

# TODO1 このページのaタグをすべて抜き出してください。(HTMLの内容)
real_page_tags = soup.find_all("a")
for tag in real_page_tags:
print(tag)

# TODO2 このページのaタグをすべて抜き出してください。(HTMLの内容)

for tag in real_page_tags:
print(tag.string)
# TODO3 このページのaタグをすべて抜き出してください。(HTMLの内容)

for tag in real_page_tags:
print(tag.get("href"))