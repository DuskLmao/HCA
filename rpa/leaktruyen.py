import requests
import re
import mysql.connector

mydb = mysql.connector.connect(
  host="10.8.0.1",
  user="hca_dev",
  password="Hca@123",
  database="hca_test"
)

matchChapterPattern = r"<span id=\"totalChapter\">([0-9]+)"
matchChapterListPattern = r"<li><span class=\"glyphicon glyphicon-certificate\"></span><a href=\"(.*?)\" title="

def getChapterNumber(url): 
  r = requests.get(url)
  maxChapter = re.findall(matchChapterPattern, r.text)[0]
  return maxChapter

def getChapterUrlByPage(url, page):
  r = requests.get(url + "?page=" + str(page))
  return re.findall(matchChapterListPattern, r.text.strip().replace('\\', ''))

def getContent(url):
  r = requests.get("https://truyenchu.vn/" + url)
  pattern = "<p>(.*?)<\/p>"
  strInp = r.text
  match = re.findall(pattern, strInp)
  s1 = re.sub("<(\S?)[^>]>.?|<.*?/>", "", match[0])
  # print(re.sub("<(\S?)[^>]><.*?/>", "", s1))
  # print(match[0].replace(, ""))
  return s1

URL = "https://truyenchu.vn/nghich-thien-ta-than"

currentChapter = 0
maxChapter = getChapterNumber(URL)

# getContent(getChapterUrlByPage(URL, 1)[0])

count = 0
countId = 1
for i in range(0, int(maxChapter) + 1):
  link = getChapterUrlByPage(URL, i)
  for j in link:
    # with open('chap' + str(count) + '.txt', 'w+', encoding='utf-8') as f:
    #   f.write(getContent(j))
    # count+=1
    mycursor = mydb.cursor()
    sql = "INSERT INTO chapters (name, title, view) VALUES (%s, %s, %s)"
    val = ("Chapter " + str(count), "Chapter " + str(count), 0)
    mycursor.execute(sql, val)

    sql = "INSERT INTO comic_content (chapter_id, comic_id, comic_content) VALUES (%s, %s, %s)"
    val = (countId ,14, getContent(j))
    mycursor.execute(sql, val)

    mydb.commit()
    count+=1
    countId+=1

print(maxChapter)

# TODO: GET CHAPTER CONTENT + ADD VÀO DB