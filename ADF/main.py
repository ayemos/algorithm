import json

f = open('./data.json', 'r')

jsonData = json.load(f)
for l in jsonData["members"]:
    for k, v in l.iteritems():
        if(k == "real_name"):
            if (v != ""):
                print v



f.close()
