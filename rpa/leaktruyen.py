import requests
import re
import mysql.connector


matchChapterPattern = r"<span id=\"totalChapter\">([0-9]+)"
matchChapterListPattern = r"<li><span class=\"glyphicon glyphicon-certificate\"></span><a href=\"(.*?)\" title="

def getChapterNumber(url): 
  r = requests.get(url)
  maxChapter = re.findall(matchChapterPattern, r.text)[0]
  return maxChapter

def getChapterUrlByPage(url, page):
  r = requests.get(url + "?page=" + str(page))
  return re.findall(matchChapterListPattern, r.text.strip().replace('\\', ''))

URL = "https://truyenchu.vn/dai-quan-gia-la-ma-hoang"

currentChapter = 0
maxChapter = getChapterNumber(URL)

# TODO: GET CHAPTER CONTENT + ADD VÀO DB