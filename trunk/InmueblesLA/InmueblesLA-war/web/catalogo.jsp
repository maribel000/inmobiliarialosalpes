<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : catalogo
    Created on : Oct 30, 2010, 9:26:08 AM
    Author     : andres
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <webuijsf:tabSet id="tabSet1" selected="tab1" style="height: 238px; left: 48px; top: 48px; position: absolute; width: 622px">
                            <webuijsf:tab actionExpression="#{catalogo.tab1_action}" id="tab1" text="Catalogo Público">
                                <webuijsf:panelLayout id="layoutPanel1" style="height: 201px; position: relative; width: 621px; -rave-layout: grid">
                                    <h:panelGrid id="gridPanel1" style="height: 192px; left: 0px; top: 0px; position: absolute" width="600">
                                        <webuijsf:textArea id="textArea1" text="asdfsdfa"/>
                                    </h:panelGrid>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                            <webuijsf:tab id="tab2" text="Privado">
                                <webuijsf:panelLayout id="layoutPanel2" style="height: 201px; position: relative; width: 621px; -rave-layout: grid">
                                    <h:panelGrid id="gridPanel2" style="height: 192px; left: 0px; top: 0px; position: absolute" width="624">
                                        <webuijsf:checkbox id="checkbox1" label="Checkbox"/>
                                    </h:panelGrid>
                                </webuijsf:panelLayout>
                            </webuijsf:tab>
                        </webuijsf:tabSet>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
