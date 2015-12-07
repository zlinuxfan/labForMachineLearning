#!/usr/bin/evn python3

import cv2 as cv
import sys

img = cv.imread(sys.argv[1], 1)
print(img)
cv.imshow("original", img)
gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)
gray = cv.GaussianBlur(gray, (7, 7), 1.5)
edges = cv.Canny(gray, 0, 50)
cv.imshow("edges", edges)
cv.waitKey()
