//!function(a){var b,c={saveSelection:function(){a(this).data("editor").focus(),window.getSelection?(sel=window.getSelection(),sel.getRangeAt&&sel.rangeCount&&a(this).data("currentRange",sel.getRangeAt(0))):document.selection&&document.selection.createRange?a(this).data("currentRange",document.selection.createRange()):a(this).data("currentRange",null)},restoreSelection:function(b,c){var d,e=a(this).data("currentRange");if(e)if(window.getSelection){if(b)if(e.deleteContents(),"html"==c){var f=document.createElement("div");f.innerHTML=b;for(var d,g,h=document.createDocumentFragment();d=f.firstChild;)g=h.appendChild(d);e.insertNode(h)}else e.insertNode(document.createTextNode(b));sel=window.getSelection(),sel.removeAllRanges(),sel.addRange(e)}else document.selection&&e.select&&(e.select(),b&&("html"==c?e.pasteHTML(b):e.text=b))},restoreIESelection:function(){var b=a(this).data("currentRange");b&&(window.getSelection?(sel=window.getSelection(),sel.removeAllRanges(),sel.addRange(b)):document.selection&&b.select&&b.select())},insertTextAtSelection:function(a,b){var c,d,e;if(window.getSelection){if(c=window.getSelection(),c.getRangeAt&&c.rangeCount){d=c.getRangeAt(0),d.deleteContents();var f=document.createTextNode(a);if("html"==b){var g=document.createElement("div");g.innerHTML=a;for(var e,h,i=document.createDocumentFragment();e=g.firstChild;)h=i.appendChild(e);d.insertNode(i)}else d.insertNode(f),d.selectNode(f);c.removeAllRanges(),d=d.cloneRange(),d.collapse(!1),c.addRange(d)}}else document.selection&&document.selection.createRange&&(d=document.selection.createRange(),d.pasteHTML(a),d.select())},imageWidget:function(){var b=a("<div/>",{class:"row gutter"}).append(a("<div/>",{id:"imgErrMsg"})),d=a("<div/>",{class:"tabbable tabs-left"}),e=a("<ul/>",{class:"nav nav-tabs"}).append(a("<li/>",{class:"active"}).append(a("<a/>",{href:"#uploadImageBar","data-toggle":"tab"}).html("From Computer"))).append(a("<li/>").append(a("<a/>",{href:"#imageFromLinkBar","data-toggle":"tab"}).html("From URL"))),f=a("<div/>",{class:"tab-content"}),g=a("<div/>",{id:"uploadImageBar",class:"tab-pane active"});handleFileSelect=function(b){for(var d,e=b.target.files,f=0;d=e[f];f++)if(d.type.match("image.*")&&d.name.match(/(?:gif|jpg|png|jpeg)$/)){var g=new FileReader;g.onload=function(b){return function(c){var d=a("<li/>",{class:"col-xs-12 col-sm-6 col-md-3 col-lg-3"}),e=a("<a/>",{href:"javascript:void(0)",class:"thumbnail"});a("<img/>",{src:c.target.result,title:escape(b.name)}).appendTo(e).click(function(){a("#imageList").data("current",a(this).attr("src"))});d.append(e).appendTo(a("#imageList"))}}(d),g.readAsDataURL(d)}else c.showMessage.apply(this,["imgErrMsg","Invalid file type"])};var h=a("<input/>",{type:"file",class:"inline-form-control",multiple:"multiple"});h.on("change",handleFileSelect),g.append(h);var i=a("<div/>",{id:"imageFromLinkBar",class:"tab-pane"}),j=a("<div/>",{class:"input-group"});a("<input/>",{type:"url",class:"form-control",id:"imageURL",placeholder:"Enter URL"}).appendTo(j),a("<button/>",{class:"btn btn-success",type:"button"}).html("Go!").click(function(){var b=a("#imageURL").val();if(""==b)return c.showMessage.apply(this,["imgErrMsg","Please enter image url"]),!1;var d=a("<li/>",{class:"span6 col-xs-12 col-sm-6 col-md-3 col-lg-3"}),e=a("<a/>",{href:"javascript:void(0)",class:"thumbnail"});a("<img/>",{src:b}).error(function(){return c.showMessage.apply(this,["imgErrMsg","Invalid image url"]),!1}).load(function(){a(this).appendTo(e).click(function(){a("#imageList").data("current",a(this).attr("src"))}),d.append(e).appendTo(a("#imageList"))})}).appendTo(a("<span/>",{class:"input-group-btn form-control-button-right"}).appendTo(j));i.append(j),f.append(g).append(i),d.append(e).append(f);var k=a("<div/>",{class:"col-xs-12 col-sm-12 col-md-12 col-lg-12"});a("<ul/>",{class:"thumbnails padding-top list-unstyled",id:"imageList"}).appendTo(k);return b.append(d).append(k),b},tableWidget:function(b){var c="";"undefined"!=typeof b&&(c="Edt");var d=a("<div/>",{class:"row gutter"}).append(a("<div/>",{id:"tblErrMsg"+c})).append(a("<form/>",{id:"tblForm"+c}).append(a("<div/>",{class:"row gutter"}).append(a("<div/>",{id:"tblInputsLeft"+c,class:"col-xs-12 col-sm-6 col-md-6 col-lg-6"}).append(a("<label/>",{for:"tblRows"+c,text:"Rows"})).append(a("<input/>",{id:"tblRows"+c,type:"text",class:"form-control form-control-width",value:2})).append(a("<label/>",{for:"tblColumns"+c,text:"Columns"})).append(a("<input/>",{id:"tblColumns"+c,type:"text",class:"form-control form-control-width",value:2})).append(a("<label/>",{for:"tblWidth"+c,text:"Width"})).append(a("<input/>",{id:"tblWidth"+c,type:"text",class:"form-control form-control-width",value:400})).append(a("<label/>",{for:"tblHeight"+c,text:"Height"})).append(a("<input/>",{id:"tblHeight"+c,type:"text",class:"form-control form-control-width"}))).append(a("<div/>",{id:"tblInputsRight"+c,class:"col-xs-12 col-sm-6 col-md-6 col-lg-6"}).append(a("<label/>",{for:"tblAlign"+c,text:"Alignment"})).append(a("<select/>",{id:"tblAlign"+c,class:"form-control form-control-width"}).append(a("<option/>",{text:"Choose",value:""})).append(a("<option/>",{text:"Left",value:"left"})).append(a("<option/>",{text:"Center",value:"center"})).append(a("<option/>",{text:"Right",value:"right"}))).append(a("<label/>",{for:"tblBorder"+c,text:"Border size"})).append(a("<input/>",{id:"tblBorder"+c,type:"text",class:"form-control form-control-width",value:1})).append(a("<label/>",{for:"tblCellspacing"+c,text:"Cell spacing"})).append(a("<input/>",{id:"tblCellspacing"+c,type:"text",class:"form-control form-control-width",value:1})).append(a("<label/>",{for:"tblCellpadding"+c,text:"Cell padding"})).append(a("<input/>",{id:"tblCellpadding"+c,type:"text",class:"form-control form-control-width",value:1})))));return d},imageAttributeWidget:function(){var b=a("<div/>",{class:"row gutter"}).append(a("<div/>",{id:"imageErrMsg"})).append(a("<input/>",{id:"imgAlt",type:"text",class:"form-control form-control-link ",placeholder:"Alt Text"})).append(a("<input/>",{id:"imgTarget",class:"form-control form-control-link ",type:"text",placeholder:"Link Target"})).append(a("<input/>",{id:"imgHidden",type:"hidden"}));return b},getHTMLTable:function(b,c,d){for(var e=a("<table/>",{class:"table"}),f=0;f<d.length;f++)""!=d[f].value&&("width"==d[f].attribute||"height"==d[f].attribute?e.css(d[f].attribute,d[f].value):e.attr(d[f].attribute,d[f].value));for(var f=1;f<=b;f++){for(var g=a("<tr/>"),h=1;h<=c;h++){var i=a("<td/>").html("&nbsp;");i.appendTo(g)}g.appendTo(e)}return e},init:function(d){var e={"Sans serif":"arial,helvetica,sans-serif",Serif:"times new roman,serif",Wide:"arial black,sans-serif",Narrow:"arial narrow,sans-serif","Comic Sans MS":"comic sans ms,sans-serif","Courier New":"courier new,monospace",Garamond:"garamond,serif",Georgia:"georgia,serif",Tahoma:"tahoma,sans-serif","Trebuchet MS":"trebuchet ms,sans-serif",Verdana:"verdana,sans-serif"},f={"Heading 1":"<h1>","Heading 2":"<h2>","Heading 3":"<h3>","Heading 4":"<h4>","Heading 5":"<h5>","Heading 6":"<h6>",Paragraph:"<p>"},g={Small:"2",Normal:"3",Medium:"4",Large:"5",Huge:"6"},h=[{name:"Black",hex:"#000000"},{name:"MediumBlack",hex:"#444444"},{name:"LightBlack",hex:"#666666"},{name:"DimBlack",hex:"#999999"},{name:"Gray",hex:"#CCCCCC"},{name:"DimGray",hex:"#EEEEEE"},{name:"LightGray",hex:"#F3F3F3"},{name:"White",hex:"#FFFFFF"},{name:"libreak",hex:null},{name:"Red",hex:"#FF0000"},{name:"Orange",hex:"#FF9900"},{name:"Yellow",hex:"#FFFF00"},{name:"Lime",hex:"#00FF00"},{name:"Cyan",hex:"#00FFFF"},{name:"Blue",hex:"#0000FF"},{name:"BlueViolet",hex:"#8A2BE2"},{name:"Magenta",hex:"#FF00FF"},{name:"libreak",hex:null},{name:"LightPink",hex:"#FFB6C1"},{name:"Bisque",hex:"#FCE5CD"},{name:"BlanchedAlmond",hex:"#FFF2CC"},{name:"LightLime",hex:"#D9EAD3"},{name:"LightCyan",hex:"#D0E0E3"},{name:"AliceBlue",hex:"#CFE2F3"},{name:"Lavender",hex:"#D9D2E9"},{name:"Thistle",hex:"#EAD1DC"},{name:"LightCoral",hex:"#EA9999"},{name:"Wheat",hex:"#F9CB9C"},{name:"NavajoWhite",hex:"#FFE599"},{name:"DarkSeaGreen",hex:"#B6D7A8"},{name:"LightBlue",hex:"#A2C4C9"},{name:"SkyBlue",hex:"#9FC5E8"},{name:"LightPurple",hex:"#B4A7D6"},{name:"PaleVioletRed",hex:"#D5A6BD"},{name:"IndianRed",hex:"#E06666"},{name:"LightSandyBrown",hex:"#F6B26B"},{name:"Khaki",hex:"#FFD966"},{name:"YellowGreen",hex:"#93C47D"},{name:"CadetBlue",hex:"#76A5AF"},{name:"DeepSkyBlue",hex:"#6FA8DC"},{name:"MediumPurple",hex:"#8E7CC3"},{name:"MediumVioletRed",hex:"#C27BA0"},{name:"Crimson",hex:"#CC0000"},{name:"SandyBrown",hex:"#E69138"},{name:"Gold",hex:"#F1C232"},{name:"MediumSeaGreen",hex:"#6AA84F"},{name:"Teal",hex:"#45818E"},{name:"SteelBlue",hex:"#3D85C6"},{name:"SlateBlue",hex:"#674EA7"},{name:"VioletRed",hex:"#A64D79"},{name:"Brown",hex:"#990000"},{name:"Chocolate",hex:"#B45F06"},{name:"GoldenRod",hex:"#BF9000"},{name:"Green",hex:"#38761D"},{name:"SlateGray",hex:"#134F5C"},{name:"RoyalBlue",hex:"#0B5394"},{name:"Indigo",hex:"#351C75"},{name:"Maroon",hex:"#741B47"},{name:"DarkRed",hex:"#660000"},{name:"SaddleBrown",hex:"#783F04"},{name:"DarkGoldenRod",hex:"#7F6000"},{name:"DarkGreen",hex:"#274E13"},{name:"DarkSlateGray",hex:"#0C343D"},{name:"Navy",hex:"#073763"},{name:"MidnightBlue",hex:"#20124D"},{name:"DarkMaroon",hex:"#4C1130"}],i=[{name:"Exclamation ",text:"!"},{name:"At",text:"@"},{name:"Hash",text:"#"},{name:"Percentage",text:"%"},{name:"Uppercase",text:"^"},{name:"Ampersand",text:"&"},{name:"Asterisk",text:"*"},{name:"OpenBracket",text:"("},{name:"CloseBracket",text:")"},{name:"Underscore",text:"_"},{name:"Hiphen",text:"-"},{name:"Plus",text:"+"},{name:"Equalto",text:"="},{name:"OpenSquareBracket",text:"["},{name:"CloseSquareBracket",text:"]"},{name:"OpenCurly",text:"{"},{name:"CloseCurly",text:"}"},{name:"Pipe",text:"|"},{name:"Colon",text:":"},{name:"Semicolon",text:";"},{name:"Single quote",text:"&#39;"},{name:"Double quote",text:"&#34;"},{name:"Left single curly quote",text:"&lsquo;"},{name:"right single curly quote",text:"&rsquo;"},{name:"Forward-slash",text:"&#47;"},{name:"Back-slash",text:"&#92;"},{name:"LessThan",text:"<"},{name:"GreaterThan",text:">"},{name:"QuestionMark",text:"?"},{name:"Tilda",text:"~"},{name:"Grave accent",text:"`"},{name:"Micron",text:"&micro;"},{name:"Paragraph sign",text:"&para;"},{name:"Plus/minus",text:"&plusmn;"},{name:"Trademark",text:"&trade;"},{name:"Copyright",text:"&copy;"},{name:"Registered",text:"&reg;"},{name:"Section",text:"&sect;"},{name:"right double angle quotes",text:"&#187;"},{name:"fraction one quarter",text:"&#188;"},{name:"fraction one half",text:"&#189;"},{name:"fraction three quarters",text:"&#190;"},{name:"Dollar",text:"$"},{name:"Euro",text:"&euro;"},{name:"Pound",text:"&pound;"},{name:"Yen",text:"&yen;"},{name:"Cent",text:"&#162;"},{name:"IndianRupee",text:"&#8377;"}],j={fonteffects:!0,texteffects:!0,aligneffects:!0,textformats:!0,actions:!0,insertoptions:!0,extraeffects:!0,advancedoptions:!0,screeneffects:!0,fonts:{select:!0,default:"Font",tooltip:"Fonts",commandname:"fontName",custom:null},styles:{select:!0,default:"Formatting",tooltip:"Paragraph Format",commandname:"formatBlock",custom:null},font_size:{select:!0,default:"Font size",tooltip:"Font Size",commandname:"fontSize",custom:null},color:{text:"A",icon:"fa fa-font",tooltip:"Text/Background Color",commandname:null,custom:function(b){var d=a(this),e=0,f=a("<div/>",{id:"paletteCntr",class:"activeColour",css:{display:"none",width:"335px"}}).click(function(a){a.stopPropagation()}),g=a("<div/>",{id:"colorpellete"}),i=a("<ul />",{id:"color_ui"}).append(a("<li />").css({width:"145px",display:"Block",height:"25px"}).html("<div>Text Color</div>")),j=a("<div/>",{id:"bg_colorpellete"}),k=a("<ul />",{id:"bgcolor_ui"}).append(a("<li />").css({width:"145px",display:"Block",height:"25px"}).html("<div>Background Color</div>"));if(d.data("colorBtn")?(e=1,d.data("colorBtn",null)):d.data("colorBtn",1),0==e){for(var l=0;l<h.length;l++)null!=h[l].hex?(i.append(a("<li />").css("background-color",h[l].hex).mousedown(function(a){a.preventDefault()}).click(function(){var b=c.rgbToHex.apply(this,[a(this).css("background-color")]);c.restoreSelection.apply(this),c.setStyleWithCSS.apply(this),document.execCommand("forecolor",!1,b),a("#paletteCntr").remove(),d.data("colorBtn",null)})),k.append(a("<li />").css("background-color",h[l].hex).mousedown(function(a){a.preventDefault()}).click(function(){var b=c.rgbToHex.apply(this,[a(this).css("background-color")]);c.restoreSelection.apply(this),c.setStyleWithCSS.apply(this),document.execCommand("backColor",!1,b),a("#paletteCntr").remove(),d.data("colorBtn",null)}))):(i.append(a("<li />").css({width:"145px",display:"Block",height:"5px"})),k.append(a("<li />").css({width:"145px",display:"Block",height:"5px"})));i.appendTo(g),k.appendTo(j),g.appendTo(f),j.appendTo(f),f.insertAfter(b),a("#paletteCntr").slideDown("slow")}else a("#paletteCntr").remove()}},bold:{text:"B",icon:"fa fa-bold",tooltip:"Bold",commandname:"bold",custom:null},italics:{text:"I",icon:"fa fa-italic",tooltip:"Italics",commandname:"italic",custom:null},underline:{text:"U",icon:"fa fa-underline",tooltip:"Underline",commandname:"underline",custom:null},strikeout:{text:"Strikeout",icon:"fa fa-strikethrough",tooltip:"Strike Through",commandname:"strikeThrough",custom:null},ol:{text:"N",icon:"fa fa-list-ol",tooltip:"Insert/Remove Numbered List",commandname:"insertorderedlist",custom:null},ul:{text:"Bullet",icon:"fa fa-list-ul",tooltip:"Insert/Remove Bulleted List",commandname:"insertunorderedlist",custom:null},undo:{text:"undo",icon:"fa fa-undo",tooltip:"Undo",commandname:"undo",custom:null},redo:{text:"redo",icon:"fa fa-repeat",tooltip:"Redo",commandname:"redo",custom:null},l_align:{text:"leftalign",icon:"fa fa-align-left",tooltip:"Align Left",commandname:"justifyleft",custom:null},r_align:{text:"rightalign",icon:"fa fa-align-right",tooltip:"Align Right",commandname:"justifyright",custom:null},c_align:{text:"centeralign",icon:"fa fa-align-center",tooltip:"Align Center",commandname:"justifycenter",custom:null},justify:{text:"justify",icon:"fa fa-align-justify",tooltip:"Justify",commandname:"justifyfull",custom:null},unlink:{text:"Unlink",icon:"fa fa-unlink",tooltip:"Unlink",commandname:"unlink",custom:null},insert_link:{modal:!0,modalId:"InsertLink",icon:"fa fa-link",tooltip:"Insert Link",modalHeader:"Insert Hyperlink",modalBody:a("<div/>",{class:"form-group"}).append(a("<div/>",{id:"errMsg"})).append(a("<input/>",{type:"text",id:"inputText",class:"form-control form-control-link ",placeholder:"Text to Display"})).append(a("<input/>",{type:"text",id:"inputUrl",required:!0,class:"form-control form-control-link",placeholder:"Enter URL"})),beforeLoad:function(){b=this,a("#inputText").val(""),a("#inputUrl").val(""),a(".alert").alert("close"),""!=a(b).data("currentRange")&&a("#inputText").val(a(b).data("currentRange"))},onSave:function(){var d=/(http|ftp|https):\/\/[\w-]+(\.[\w-]+)+([\w.,@?^=%&amp;:\/~+#-]*[\w@?^=%&amp;\/~+#-])?/,e=a("#inputText").val(),f=a("#inputUrl").val(),g=a(b).data("currentRange");if(""==f)return c.showMessage.apply(b,["errMsg","Please enter url"]),!1;if(!f.match(d))return c.showMessage.apply(b,["errMsg","Enter valid url"]),!1;if(""==g&&""==e&&(e=f),navigator.userAgent.match(/MSIE/i)){var h='<a href="'+f+'" target="_blank">'+e+"</a>";c.restoreSelection.apply(b,[h,"html"])}else c.restoreSelection.apply(b,[e]),document.execCommand("createLink",!1,f);return a(b).data("editor").find('a[href="'+f+'"]').each(function(){a(this).attr("target","_blank")}),a(".alert").alert("close"),a("#InsertLink").modal("hide"),a(b).data("editor").focus(),!1}},insert_img:{modal:!0,modalId:"InsertImage",icon:"fa fa-picture-o",tooltip:"Insert Image",modalHeader:"Insert Image",modalBody:c.imageWidget.apply(this),beforeLoad:function(){a("#imageURL").val(""),a("#uploadImageBar :input").val(""),a("#imageList").data("current","")},onSave:function(){if(c.restoreSelection.apply(this),!a("#imageList").data("current"))return c.showMessage.apply(this,["imgErrMsg","Please select an image"]),!1;if(navigator.userAgent.match(/MSIE/i)){var b='<img src="'+a("#imageList").data("current")+'"/>';c.restoreSelection.apply(this,[b,"html"])}else document.execCommand("insertimage",!1,a("#imageList").data("current"));a("#InsertImage").modal("hide"),a(this).data("editor").focus()}},insert_table:{modal:!0,modalId:"InsertTable",icon:"fa fa-table",tooltip:"Insert Table",modalHeader:"Insert Table",modalBody:c.tableWidget.apply(this),beforeLoad:function(){a("#tblForm").each(function(){this.reset()})},onSave:function(){c.restoreSelection.apply(this);var b=a("#tblRows").val(),d=a("#tblColumns").val(),e=a("#tblWidth").val(),f=a("#tblHeight").val(),g=a("#tblAlign").val(),h=a("#tblBorder").val(),i=a("#tblCellspacing").val(),j=a("#tblCellpadding").val(),k=/^[0-9]+$/,l=/^auto$|^[+-]?[0-9]+\.?([0-9]+)?(px|em|ex|%|in|cm|mm|pt|pc)?$/gi,m=/^[0-9]+\.?([0-9])?$/;if(!b.match(k))return c.showMessage.apply(this,["tblErrMsg","Rows must be a positive number"]),!1;if(!d.match(k))return c.showMessage.apply(this,["tblErrMsg","Columns must be a positive number"]),!1;if(""!=e&&!e.match(l))return c.showMessage.apply(this,["tblErrMsg","Please enter positive number with or without a valid CSS measurement unit (px,em,ex,%,in,cm,mm,pt,pc)"]),!1;if(""!=f&&!f.match(l))return c.showMessage.apply(this,["tblErrMsg","Please enter positive number with or without a valid CSS measurement unit (px,em,ex,%,in,cm,mm,pt,pc)"]),!1;if(""!=h&&!h.match(m))return c.showMessage.apply(this,["tblErrMsg","Border size must be a positive number"]),!1;if(""!=i&&!i.match(m))return c.showMessage.apply(this,["tblErrMsg","Cell spacing must be a positive number"]),!1;if(""!=j&&!j.match(m))return c.showMessage.apply(this,["tblErrMsg","Cell padding must be a positive number"]),!1;var n=a("<div/>"),o=[{attribute:"align",value:g},{attribute:"border",value:h},{attribute:"cellspacing",value:i},{attribute:"cellpadding",value:j},{attribute:"width",value:e},{attribute:"height",value:f}],p=c.getHTMLTable.apply(this,[b,d,o]);p.appendTo(n),navigator.userAgent.match(/MSIE/i)?c.restoreSelection.apply(this,[n.html(),"html"]):document.execCommand("insertHTML",!1,n.html()),a("#InsertTable").modal("hide"),a(this).data("editor").focus()}},hr_line:{text:"HR",icon:"fa fa-minus",tooltip:"Horizontal Rule",commandname:"insertHorizontalRule",custom:null},block_quote:{text:"Block Quote",icon:"fa fa-quote-right",tooltip:"Block Quote",commandname:null,custom:function(){c.setStyleWithCSS.apply(this),navigator.userAgent.match(/MSIE/i)?document.execCommand("indent",!1,null):document.execCommand("formatBlock",!1,"<blockquote>")}},indent:{text:"Indent",icon:"fa fa-indent",tooltip:"Increase Indent",commandname:"indent",custom:null},outdent:{text:"Outdent",icon:"fa fa-outdent",tooltip:"Decrease Indent",commandname:"outdent",custom:null},print:{text:"Print",icon:"fa fa-print",tooltip:"Print",commandname:null,custom:function(){oDoc=a(this).data("editor");var b=window.open("","_blank","width=450,height=470,left=400,top=100,menubar=yes,toolbar=no,location=no,scrollbars=yes");b.document.open(),b.document.write('<!doctype html><html><head><title>Print</title></head><body onload="print();">'+oDoc.html()+"</body></html>"),b.document.close()}},rm_format:{text:"Remove format",icon:"fa fa-eraser",tooltip:"Remove Formatting",commandname:"removeformat",custom:null},select_all:{text:"Select all",icon:"fa fa-file-text",tooltip:"Select All",commandname:null,custom:function(){document.execCommand("selectall",null,null)}},togglescreen:{text:"Toggle Screen",icon:"fa fa-arrows-alt",tooltip:"Toggle Screen",commandname:null,custom:function(b,c){a(this).data("editor").parent().toggleClass("fullscreen");var d=0;a(this).data("statusBar").length&&(d=a(this).data("statusBar").height()),a(this).data("editor").parent().hasClass("fullscreen")?a(this).data("editor").css({height:a(this).data("editor").parent().height()-(a(this).data("menuBar").height()+d)-13}):a(this).data("editor").css({height:""})}},splchars:{text:"S",icon:"fa fa-asterisk",tooltip:"Insert Special Character",commandname:null,custom:function(b){c.restoreIESelection.apply(this);var d=0,e=a("<div/>",{id:"specialchar",class:"specialCntr",css:{display:"none"}}).click(function(a){a.stopPropagation()}),f=a("<ul />",{id:"special_ui"}),g=this;if(a(this).data("editor").data("splcharsBtn")?(d=1,a(this).data("editor").data("splcharsBtn",null)):a(this).data("editor").data("splcharsBtn",1),0==d){for(var h=0;h<i.length;h++)f.append(a("<li />").html(i[h].text).attr("title",i[h].name).mousedown(function(a){a.preventDefault()}).click(function(b){if(navigator.userAgent.match(/MSIE/i)){var d=a(this).html();c.insertTextAtSelection.apply(this,[d,"html"])}else document.execCommand("insertHTML",!1,a(this).html());a("#specialchar").remove(),a(g).data("editor").data("splcharsBtn",null)}));f.prependTo(e),e.insertAfter(b),a("#specialchar").slideDown("slow")}else a("#specialchar").remove()}},source:{text:"Source",icon:"fa fa-code",tooltip:"Source",commandname:null,custom:function(a,b){c.getSource.apply(this,[a,b])}},params:{obj:null}},k={texteffects:["bold","italics","underline","color"],aligneffects:["l_align","c_align","r_align","justify"],textformats:["indent","outdent","block_quote","ol","ul"],fonteffects:["fonts","styles","font_size"],actions:["undo","redo"],insertoptions:["insert_link","unlink","insert_img","insert_table"],extraeffects:["strikeout","hr_line","splchars"],advancedoptions:["print","rm_format","select_all","source"],screeneffects:["togglescreen"]},l=a.extend({texteffects:!0,aligneffects:!0,textformats:!0,fonteffects:!0,actions:!0,insertoptions:!0,extraeffects:!0,advancedoptions:!0,screeneffects:!0,bold:!0,italics:!0,underline:!0,ol:!0,ul:!0,undo:!0,redo:!0,l_align:!0,r_align:!0,c_align:!0,justify:!0,insert_link:!0,unlink:!0,insert_img:!0,hr_line:!0,block_quote:!0,source:!0,strikeout:!0,indent:!0,outdent:!0,fonts:e,styles:f,print:!0,rm_format:!0,status_bar:!0,font_size:g,color:h,splchars:i,insert_table:!0,select_all:!0,togglescreen:!0},d),m=a("<div/>",{class:"Editor-container"}),n=a(this).hide();n.after(m);var o=a("<div/>",{id:"menuBarDiv",class:"row gutter"}).prependTo(m),p=a("<div/>",{class:"Editor-editor",css:{overflow:"auto"},contenteditable:"true"}).appendTo(m),q=a("<div/>",{id:"statusbar",unselectable:"on"}).appendTo(m);a(this).data("menuBar",o),a(this).data("editor",p),a(this).data("statusBar",q);var r=this;l.status_bar&&p.keyup(function(b){var d=c.getWordCount.apply(r),e=c.getCharCount.apply(r);a(r).data("statusBar").html('<div class="label">Words : '+d+"</div>"),a(r).data("statusBar").append('<div class="label">Characters : '+e+"</div>")});for(var s in j)if(l[s])if(s in k){for(var t=a("<div/>",{class:"btn-group"}),u=0;u<k[s].length;u++){var v=k[s][u];if(l[v]){var w=c.createMenuItem.apply(this,[j[v],l[v],!0]);t.append(w)}l[v]=!1}o.append(t)}else{var w=c.createMenuItem.apply(this,[j[s],l[s],!0]);o.append(w)}else if(l[s]in k)for(var x in k[s])l[x]=!1;p.bind("contextmenu",function(b){a("#context-menu").length&&a("#context-menu").remove();var d=a("<div/>",{id:"context-menu"}).css({position:"absolute",top:b.pageY,left:b.pageX,"z-index":9999}).click(function(a){a.stopPropagation()}),e=a("<ul/>",{class:"dropdown-menu on",role:"menu"});b.preventDefault(),a(b.target).is("a")?(c.createLinkContext.apply(this,[b,e]),e.appendTo(d),d.appendTo("body")):a(b.target).is("td")||a(b.target).is("th")?(c.createTableContext.apply(this,[b,e]),e.appendTo(d),d.appendTo("body")):a(b.target).is("img")&&(c.createImageContext.apply(this,[b,e]),e.appendTo(d),d.appendTo("body"))})},createLinkContext:function(b,c){var d=a("<li/>").append(a("<a/>",{id:"rem_link",href:"javascript:void(0)",text:"RemoveLink"}).click(function(b){return function(){a(b.target).contents().unwrap(),a("#context-menu").remove()}}(b)));d.appendTo(c)},createImageContext:function(b,d){var e="imgAttribute",f="Image Attributes",g=c.imageAttributeWidget.apply(this,["edit"]),h=function(){var b=/(http|ftp|https):\/\/[\w-]+(\.[\w-]+)+([\w.,@?^=%&amp;:\/~+#-]*[\w@?^=%&amp;\/~+#-])?/,d=a("#imgAlt").val(),e=a("#imgTarget").val();if(""==d)return c.showMessage.apply(this,["imageErrMsg","Please enter image alternative text"]),!1;if(""!=e&&!e.match(b))return c.showMessage.apply(this,["imageErrMsg","Please enter valid url"]),!1;if(""!=a("#imgHidden").val()){var f=a("#imgHidden").val();a("#"+f).attr("alt",d),""!=e?a("#wrap_"+f).length?a("#wrap_"+f).attr("href",e):a("#"+f).wrap(a("<a/>",{id:"wrap_"+f,href:e,target:"_blank"})):a("#wrap_"+f).length&&a("#"+f).unwrap()}a("#imgAttribute").modal("hide"),a(this).data("editor").focus()};c.createModal.apply(this,[e,f,g,h]);var i=a("<a/>",{href:"#"+e,text:"Image Attributes","data-toggle":"modal"}).click(function(b){return function(){a("#context-menu").remove();var c=(new Date).getTime();if(a("#imgAlt").val(a(b.target).closest("img").attr("alt")),a("#imgTarget").val(""),"undefined"!=typeof a(b.target).closest("img").attr("id")){var d=a(b.target).closest("img").attr("id");a("#imgHidden").val(d),a("#wrap_"+d).length?a("#imgTarget").val(a("#wrap_"+d).attr("href")):a("#imgTarget").val("")}else a(b.target).closest("img").attr("id","img_"+c),a("#imgHidden").val("img_"+c)}}(b));d.append(a("<li/>").append(i)).append(a("<li/>").append(a("<a/>",{text:"Remove Image"}).click(function(b){return function(){a("#context-menu").remove(),a(b.target).closest("img").remove()}}(b))))},createTableContext:function(b,d){a("#editProperties").remove();var e="editProperties",f="Table Properties",g=c.tableWidget.apply(this,["edit"]),h=function(){var d=a("#tblWidthEdt").val(),e=a("#tblHeightEdt").val(),f=a("#tblBorderEdt").val(),g=a("#tblAlignEdt").val(),h=a("#tblCellspacingEdt").val(),i=a("#tblCellpaddingEdt").val(),j=/^auto$|^[+-]?[0-9]+\.?([0-9]+)?(px|em|ex|%|in|cm|mm|pt|pc)?$/gi,k=/^[0-9]+\.?([0-9])?$/;return(""==d||d.match(j))&&(""==e||e.match(j))?""==f||f.match(k)?""==h||h.match(k)?""==i||i.match(k)?(a(b.target).closest("table").css("width",d),""!=e&&a(b.target).closest("table").css("height",e),a(b.target).closest("table").attr("align",g),a(b.target).closest("table").attr("border",f),a(b.target).closest("table").attr("cellspacing",h),a(b.target).closest("table").attr("cellpadding",i),a("#editProperties").modal("hide"),void a(this).data("editor").focus()):(c.showMessage.apply(this,["tblErrMsgEdt","Cell padding must be a positive number"]),!1):(c.showMessage.apply(this,["tblErrMsgEdt","Cell spacing must be a positive number"]),!1):(c.showMessage.apply(this,["tblErrMsgEdt","Border size must be a positive number"]),!1):(c.showMessage.apply(this,["tblErrMsgEdt","Please enter positive number with or without a valid CSS measurement unit (px,em,ex,%,in,cm,mm,pt,pc)"]),!1)};c.createModal.apply(this,[e,f,g,h]);var i=a("<a/>",{href:"#"+e,text:"Table Properties","data-toggle":"modal"}).click(function(b){return function(){a("#context-menu").remove(),a("#tblRowsEdt").val(a(b.target).closest("table").prop("rows").length),a("#tblColumnsEdt").val(a(b.target).closest("table").find("tr")[0].cells.length),a("#tblRowsEdt").attr("disabled","disabled"),a("#tblColumnsEdt").attr("disabled","disabled"),a("#tblWidthEdt").val(a(b.target).closest("table").get(0).style.width),a("#tblHeightEdt").val(a(b.target).closest("table").get(0).style.height),a("#tblAlignEdt").val(a(b.target).closest("table").attr("align")),a("#tblBorderEdt").val(a(b.target).closest("table").attr("border")),a("#tblCellspacingEdt").val(a(b.target).closest("table").attr("cellspacing")),a("#tblCellpaddingEdt").val(a(b.target).closest("table").attr("cellpadding"))}}(b));d.append(a("<li/>",{class:"dropdown-submenu",css:{display:"block"}}).append(a("<a/>",{tabindex:"-1",href:"javascript:void(0)",text:"Row"})).append(a("<ul/>",{class:"dropdown-menu"}).append(a("<li/>").append(a("<a/>",{id:"tbl_addrow",href:"javascript:void(0)",text:"Add Row"}).click(function(b){return function(){a("#context-menu").remove();var c=a(b.target).closest("tr"),d=a("<tr/>");c.children().each(function(){var b=a("<"+a(this).prop("nodeName")+"/>").html("&nbsp;");d.append(b)}),c.after(d)}}(b)))).append(a("<li/>").append(a("<a/>",{text:"Remove Row"}).click(function(b){return function(){a("#context-menu").remove(),a(b.target).closest("tr").remove()}}(b)))))).append(a("<li/>",{class:"dropdown-submenu",css:{display:"block"}}).append(a("<a/>",{tabindex:"-1",href:"javascript:void(0)",text:"Column"})).append(a("<ul/>",{class:"dropdown-menu"}).append(a("<li/>").append(a("<a/>",{id:"tbl_addcolumn",href:"javascript:void(0)",text:"Add Column"}).click(function(b){return function(){a("#context-menu").remove();var c=a(b.target),d=c.siblings().addBack().index(c);c.closest("table").find("tr").each(function(){var b=a(this).children(":eq("+d+")"),c=a("<"+b.prop("nodeName")+"/>").html("&nbsp;");b.after(c)})}}(b)))).append(a("<li/>").append(a("<a/>",{text:"Remove Column"}).click(function(b){return function(){a("#context-menu").remove();var c=a(b.target),d=c.siblings().addBack().index(c);c.closest("table").find("tr").each(function(){a(this).children(":eq("+d+")").remove()})}}(b)))))),d.append(a("<li/>").append(i)).append(a("<li/>",{class:"divider"})).append(a("<li/>").append(a("<a/>",{text:"Remove Table"}).click(function(b){return function(){a("#context-menu").remove(),a(b.target).closest("table").remove()}}(b))))},createModal:function(b,c,d,e){var f=a("<a/>",{href:"#"+b,role:"button",class:"btn btn-light-grey","data-toggle":"modal"}),g=a("<div/>",{id:b,class:"modal fade",tabindex:"-1",role:"dialog","aria-labelledby":"h3_"+b,"aria-hidden":"true"}).append(a("<div>",{class:"modal-dialog"}).append(a("<div>",{class:"modal-content"}).append(a("<div>",{class:"modal-header"}).append(a("<button/>",{type:"button",class:"close","data-dismiss":"modal","aria-hidden":"true"}).html("x")).append(a("<h3/>",{id:"h3_"+b}).html(c))).append(a("<div>",{class:"modal-body"}).append(d)).append(a("<div>",{class:"modal-footer"}).append(a("<button/>",{type:"button",class:"btn btn-light-grey","data-dismiss":"modal","aria-hidden":"true"}).html("Cancel")).append(a("<button/>",{type:"button",class:"btn btn-success"}).html("Done").mousedown(function(a){a.preventDefault()}).click(function(a){return function(){e.apply(a)}}(this))))));return g.appendTo("body"),f},createMenuItem:function(b,d,e){if(b.select){var f=a("<div/>",{class:"btn-group"}),g=a("<ul/>",{class:"dropdown-menu"});f.append(a("<a/>",{class:"btn btn-light-grey dropdown-toggle","data-toggle":"dropdown",href:"javascript:void(0)",title:b.tooltip}).html(b.default).append(a("<span/>",{class:"caret"})).mousedown(function(a){a.preventDefault()})),a.each(d,function(b,c){var d=a("<li/>");a("<a/>",{tabindex:"-1",href:"javascript:void(0)"}).html(b).appendTo(d),d.click(function(){a(this).parent().parent().data("value",c),a(this).parent().parent().trigger("change")}),g.append(d)});var h="change"}else{if(b.modal){var f=c.createModal.apply(this,[b.modalId,b.modalHeader,b.modalBody,b.onSave]),g=a("<i/>");return b.icon?g.addClass(b.icon):g.html(b.text),f.append(g),f.mousedown(function(a,b,c){return function(d){d.preventDefault(),b.saveSelection.apply(a),c&&c.apply(a)}}(this,c,b.beforeLoad)),f.attr("title",b.tooltip),f}var f=a("<a/>",{href:"javascript:void(0)",class:"btn btn-light-grey"}),g=a("<i/>");b.icon?g.addClass(b.icon):g.html(b.text);var h="click"}return b.custom?f.bind(h,function(d,e){return function(){c.saveSelection.apply(d),b.custom.apply(d,[a(this),e])}}(this,b.params)):(f.data("commandName",b.commandname),f.data("editor",a(this).data("editor")),f.bind(h,function(){c.setTextFormat.apply(this)})),f.attr("title",b.tooltip),f.css("cursor","pointer"),f.append(g),e?f:void a(this).data("menuBar").append(f)},setTextFormat:function(){return c.setStyleWithCSS.apply(this),document.execCommand(a(this).data("commandName"),!1,a(this).data("value")||null),a(this).data("editor").focus(),!1},getSource:function(b,c){var d=0;b.data("state")?(d=1,b.data("state",null)):b.data("state",1),a(this).data("source-mode",!d);var e,f=a(this).data("editor");if(0==d)e=document.createTextNode(f.html()),f.empty(),
//f.attr("contenteditable",!1),preElement=a("<pre/>",{contenteditable:!0}),preElement.append(e),f.append(preElement),b.parent().siblings().hide(),b.siblings().hide();else{var g=f.children().first().text();f.html(g),f.attr("contenteditable",!0),b.parent().siblings().show(),b.siblings().show()}},countWords:function(b){for(var d=0,e=b.contents().filter(function(){return 3==this.nodeType}),f=0;f<e.length;f++)text=e[f].textContent,text=text.replace(/[^-\w\s]/gi," "),text=a.trim(text),d+=text.split(/\s+/).length;b.children().each(function(){d+=c.countWords.apply(this,[a(this)])});return d},countChars:function(b){for(var d=0,e=b.contents().filter(function(){return 3==this.nodeType}),f=0;f<e.length;f++)text=e[f].textContent,d+=text.length;b.children().each(function(){d+=c.countChars.apply(this,[a(this)])});return d},getWordCount:function(){return c.countWords.apply(this,[a(this).data("editor")])},getCharCount:function(){return c.countChars.apply(this,[a(this).data("editor")])},rgbToHex:function(a){return a=a.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/),"#"+("0"+parseInt(a[1],10).toString(16)).slice(-2)+("0"+parseInt(a[2],10).toString(16)).slice(-2)+("0"+parseInt(a[3],10).toString(16)).slice(-2)},showMessage:function(b,c){var d=a("<div/>",{class:"alert alert-danger"}).append(a("<button/>",{type:"button",class:"close","data-dismiss":"alert",html:"x"})).append(a("<span/>").html(c));d.appendTo(a("#"+b)),setTimeout(function(){a(".alert").alert("close")},3e3)},getText:function(){return a(this).data("source-mode")?a(this).data("editor").children().first().text():a(this).data("editor").html()},setText:function(b){a(this).data("source-mode")?a(this).data("editor").children().first().text(b):a(this).data("editor").html(b)},setStyleWithCSS:function(){if(navigator.userAgent.match(/MSIE/i))try{Editor.execCommand("styleWithCSS",0,!1)}catch(a){try{Editor.execCommand("useCSS",0,!0)}catch(a){try{Editor.execCommand("styleWithCSS",!1,!1)}catch(a){}}}else document.execCommand("styleWithCSS",null,!0)}};a.fn.Editor=function(b){return c[b]?c[b].apply(this,Array.prototype.slice.call(arguments,1)):"object"!=typeof b&&b?void a.error("Method "+b+" does not exist on jQuery.Editor"):c.init.apply(this,arguments)}}(jQuery);