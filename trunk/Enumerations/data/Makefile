#!/bin/sh

SRC=siso-std-002.xml

DBK=docbook.xml
PDF=siso-std-002.pdf
RTF=siso-std-002.doc
XLS=siso-std-002.xls

all: $(PDF) $(RTF) $(XLS)

$(PDF): $(DBK)
	docbook2pdf $^
	mv docbook.pdf $@

$(RTF): $(DBK)
	docbook2rtf $^
	mv docbook.rtf $@

$(DBK): xml2docbook.xslt $(SRC)
	xsltproc --output $@ $^

$(XLS): xml2excel.xslt $(SRC)
	xsltproc --nonet --output $@ $^

.PHONY: tarball
tarball:
	zip -9r siso-std-002-mrebv-draft1.zip .

clean:
	rm -f $(DBK) $(PDF) $(RTF) $(XLS)
