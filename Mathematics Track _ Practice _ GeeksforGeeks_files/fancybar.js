var _bsa={init:function(format,zoneKey,segment,options){var options=typeof options!=='undefined'?options:false;if(!this.isset(window['_bsa_queue']))window['_bsa_queue']=[];if(!this.isset(options.target)){if(options===false)options=new Array();options['target']='body'}if(this.isset(options)&&this.isset(options.target)&&document.querySelectorAll(options.target).length>0){var srv=document.createElement('script');srv.id='_bsa_srv-'+zoneKey+'_'+window['_bsa_queue'].length;srv.type='text/javascript';srv.src=(options&&options.path)?options.path:'//srv.buysellads.com/ads/'+zoneKey+'.json';srv.src=this.appendQueryString(srv.src,'callback','_bsa_go');options.script_id=srv.id;if(segment)srv.src=this.appendQueryString(srv.src,'segment',segment);if(options&&this.isset(options.ip))srv.src=this.appendQueryString(srv.src,'forwardedip',options.ip);if(options&&this.isset(options.country))srv.src=this.appendQueryString(srv.src,'country',options.country);if(options&&this.isset(options.number_of_ads))srv.src=this.appendQueryString(srv.src,'forcenads',options.number_of_ads);if(options&&!this.isset(options.platforms)||!this.isset(options))options.platforms=['desktop','mobile'];if(_bsa[format].readyToInit!=false||(options&&options.testMode)||!_bsa.objExists(zoneKey))window['_bsa_queue'].push([format,zoneKey,segment,options]);if(_bsa[format].readyToInit!=false&&!options.testMode){srv.src+=this.frequencyCap();if(_bsa.objExists(zoneKey)&&!_bsa.exists(document.getElementById(srv.id)))document.getElementsByTagName('head')[0].appendChild(srv)}else if((options&&options.testMode)||!_bsa.objExists(zoneKey))_bsa_go(_bsa[format].testData);else _bsa[format](zoneKey,segment,options)}},frequencyCap:function(){var day=_bsa.getCookie('_bsap_daycap'),life=_bsa.getCookie('_bsap_lifecap'),day=this.isset(day)?day.split(';')[0].split(','):[],life=this.isset(life)?life.split(';')[0].split(','):[];if(day.length||life.length){var freqcap=[];for(var i=0;i<day.length;i++){var adspot=day[i];for(var found=-1,find=0;find<freqcap.length&&found==-1;find++)if(freqcap[find][0]==adspot)found=find;if(found==-1)freqcap.push([adspot,1,0]);else freqcap[found][1]++}for(var i=0;i<life.length;i++){var adspot=day[i];for(var found=-1,find=0;find<freqcap.length&&found==-1;find++)if(freqcap[find][0]==adspot)found=find;if(found==-1)freqcap.push([adspot,0,1]);else freqcap[found][2]++}for(var i=0;i<freqcap.length;i++)freqcap[i]=freqcap[i][0]+':'+freqcap[i][1]+','+freqcap[i][2]}if(freqcap&&freqcap.length)return'&freqcap='+encodeURIComponent(freqcap.join(';'));else return''},appendQueryString:function(url,name,value){var re=new RegExp('([?&]'+name+'=)[^&]+','');function add(sep){url+=sep+name+'='+encodeURI(value)}function change(){url=url.replace(re,'$1'+encodeURI(value))}if(url.indexOf('?')===-1){add('?')}else{if(re.test(url)){change()}else{add('&')}}return url},clearQueue:function(index){window['_bsa_queue'].splice(index,1)},link:function(link,segment,domain,timestamp){var l=link.split('?encredirect='),fulllink;if(typeof l[1]!='undefined')fulllink=l[0]+'?segment='+segment+';&encredirect='+encodeURIComponent(l[1]);else if(l[0].search('srv.buysellads.com')>0)fulllink=l[0]+'?segment='+segment+';';else fulllink=l[0];fulllink=fulllink.replace('[placement]',segment);fulllink=fulllink.replace('[timestamp]',timestamp);if(domain)fulllink=fulllink.replace(/srv.buysellads.com/g,domain);return fulllink},pixel:function(p,timestamp){var c='';if(_bsa.isset(p)){var pixels=p.split('||');for(var j=0;j<pixels.length;j++)c+='<img src="'+pixels[j].replace('[timestamp]',timestamp)+'" style="display:none;" height="0" width="0" />'}return c},findInQueue:function(key){for(i=0;i<window['_bsa_queue'].length;i++)if(window['_bsa_queue'][i][1]==key)return i},drop:function(output,target,elType,idName,attributes){var div=document.createElement(elType);div.id=idName;div.innerHTML=output;if(attributes)div.setAttribute('data-attributes',JSON.stringify(attributes));var b=document.body.firstChild;for(i=0;i<document.querySelectorAll(target).length;i++)if(target=='body')b.parentNode.insertBefore(div,b);else document.querySelectorAll(target)[i].appendChild(div)},hide:function(e){if(document.getElementById(e)){this.removeClass(document.getElementById(e),'_bsa_show');this.addClass(document.getElementById(e),'_bsa_hide')}},show:function(e){if(document.getElementById(e)){this.removeClass(document.getElementById(e),'_bsa_hide');this.addClass(document.getElementById(e),'_bsa_show')}},close:function(e,t){this.hide(e);if(this.isset(_bsa.setCookie))_bsa.setCookie(e,'hide',this.isset(t)?t:1000*60*60*24)},hasClass:function(el,name){return new RegExp('(\\s|^)'+name+'(\\s|$)').test(el.className)},addClass:function(el,name){if(!this.hasClass(el,name))el.className+=(el.className?' ':'')+name},removeClass:function(el,name){if(this.hasClass(el,name))el.className=el.className.replace(new RegExp('(\\s|^)'+name+'(\\s|$)'),' ').replace(/^\s+|\s+$/g,'')},removeElement:function(el){if(typeof el!=='undefined'&&el!=null)el.parentNode.removeChild(el)},emptyElement:function(el){while(el.firstChild)el.removeChild(el.firstChild)},reload:function(e){var el=document.querySelector(e);if(typeof el!=='undefined'&&el!=null){var attributes=JSON.parse(el.firstChild.getAttribute('data-attributes'));this.removeElement(document.getElementById(attributes.options.script_id));this.emptyElement(el);this.init(attributes.type,attributes.key,attributes.segment,attributes.options)}},isHex:function(c){return/(^#[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i.test(c)},isMobile:function(){var check=false;(function(a){if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4)))check=true})(navigator.userAgent||navigator.vendor||window.opera);return check},extend:function(target){for(var i=1;i<arguments.length;++i){var from=arguments[i];if(typeof from!=='object')continue;for(var j in from){if(from.hasOwnProperty(j)){target[j]=typeof from[j]==='object'?this.extend({},target[j],from[j]):from[j]}}}return target},isset:function(v){return typeof v!=='undefined'&&v!=null},exists:function(el){if(el===null)return false;return true},objExists:function(obj){var hasOwnProperty=Object.prototype.hasOwnProperty;if(obj==null)return false;if(obj.length>0)return true;if(obj.length===0)return false;for(var key in obj)if(hasOwnProperty.call(obj,key))return true;return false},getAttr:function(v,id){return document.getElementById(id).getAttribute('data-'+v)},getUrlVar:function(el,name){name=name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");var regexS="[\\?&]"+name+"=([^&#]*)",regex=new RegExp(regexS),results=regex.exec(el.src);if(results==null)return'';else return results[1]}};var _bsa_go=function(json){var queue_index=_bsa.findInQueue(json['ads'][0].zonekey);if(window['_bsa_queue'][queue_index])if((window['_bsa_queue'][queue_index][3]&&window['_bsa_queue'][queue_index][3].platforms.indexOf('mobile')>-1&&_bsa.isMobile())||(window['_bsa_queue'][queue_index][3]&&window['_bsa_queue'][queue_index][3].platforms.indexOf('desktop')>-1&&!_bsa.isMobile()))if(_bsa.isset(json))for(i=json['ads'].length-1;i>=0;i--)if(!_bsa.isset(json['ads'][i].statlink))json['ads'].splice(i,1);if(_bsa.isset(json)&&_bsa.isset(json['ads'])&&json['ads'].length>0&&_bsa.isset(json['ads'][0].statlink)){for(var i=0;i<json['ads'].length;i++)_bsa_serving_callback(json['ads'][i].bannerid,json['ads'][i].zonekey,json['ads'][i].freqcap);_bsa[window['_bsa_queue'][queue_index][0]](window['_bsa_queue'][queue_index][1],window['_bsa_queue'][queue_index][2],window['_bsa_queue'][queue_index][3],json['ads'])}};_bsa.testData={ads:[{backgroundColor:'red',backgroundHoverColor:'#ffffff',callToAction:'Try now',company:'Company Name',ctaBackgroundColor:'#0072c6',ctaBackgroundHoverColor:'#0089ee',description:'We build widgets, and we think you should try them!',image:'https://cdn4.buysellads.net/uu/1/18/1504373058-32397.png',logo:'https://cdn4.buysellads.net/uu/1/18/1504373139-azure-1.png',statlink:'//www.buysellads.com/',textColor:'#ffffff',textColorHover:'#ffffff',timestamp:'1508185654',title:'The best widgets'}]};_bsa.getCookie=function(name){var nameEQ=name+'=',ca=document.cookie.split(';');for(var i=0;i<ca.length;i++){var c=ca[i];while(c.charAt(0)==' ')c=c.substring(1,c.length);if(c.indexOf(nameEQ)==0)return c.substring(nameEQ.length,c.length)}return null};_bsa.setCookie=function(name,value,seconds){if(seconds){var date=new Date();date.setTime(date.getTime()+seconds);var expires='; expires='+date.toGMTString()}else var expires='';document.cookie=name+'='+value+expires+'; path=/'};_bsa.removeCookie=function(name){this.setCookie(name,'',-1)};window['_bsa_serving_callback']=function(banner,zone,freqcap){var append=function(w,data,days){var c=document.cookie,i=c.indexOf(w+'='),existing=i>=0?c.substring(i+w.length+1).split(';')[0]+',':'',d=new Date();d.setTime(days*3600000+d);data=existing+data;data=data.substring(0,2048);document.cookie=w+'='+data+'; expires='+d.toGMTString()+'; path=\/'};if(freqcap){append('_bsap_daycap',banner,1);append('_bsap_lifecap',banner,365)}};_bsa.fancybar=function(zoneKey,segment,options,ads){var disable_css=_bsa.isset(options)&&_bsa.isset(options.disable_css)?options.disable_css:false;var custom_domain=_bsa.isset(options)&&_bsa.isset(options.custom_domain)?options.custom_domain:false;function temp_zonekey(segment){var reroute=new Array();reroute['placement:coingecko']='CKYDKKQE';reroute['placement:bitcoincom']='CKYDKKQJ';reroute['placement:worldcoinindex']='CKYDKKQL';reroute['placement:bitinfocharts']='CKYDKKQI';reroute['placement:newsbtc']='CKYDKKQW';reroute['placement:bitcoinforecast']='CKYDKKQM';reroute['placement:coinmarketcal']='CKYDKKQN';reroute['placement:advfn']='CKYDKKQU';reroute['placement:coincodex']='CKYDKKQY';reroute['placement:thebitcoinpub']='CKYDKKQ7';reroute['placement:cryptoid']='CKYDKKJE';reroute['placement:99bitcoins']='CKYDKKJJ';reroute['placement:cryptocoinsnews']='CKYDKKJL';reroute['placement:weekinethereum']='CKYDKKJI';reroute['placement:flippeningwatch']='CKYDKKJW';reroute['placement:bitinfocharts']='CKYDKKQI';reroute['placement:geeksforgeeks']='CKYDL2JJ';reroute['placement:pastebin']='CKYDL2JL';reroute['placement:danstools']='CKYDL27W';reroute['placement:programiz']='CKYDL27L';reroute['placement:seeklogo']='CKYDL27J';reroute['placement:howtoforge']='CKYDL27E';reroute['placement:unixdotcom']='CKYDL2J7';reroute['placement:speckyboy']='CKYDL2JY';reroute['placement:jsonlint']='CKYDL2JU';reroute['placement:w3layouts']='CKYDL2JN';reroute['placement:graphicdesignjunction']='CKYDL53E';reroute['placement:htmlcom']='CKYDL2JW';reroute['placement:freevector']='CKYDL2JI';reroute['placement:java2novice']='CKYDL277';reroute['placement:coursetro']='CKYDL27Y';reroute['placement:1stwebdesigner']='CKYDL27U';reroute['placement:tinypaste']='CKYDL53J';reroute['placement:entityframeworktutorial']='CKYDL27N';reroute['placement:vandelaydesign']='CKYDL27M';reroute['placement:photoshoptutorials']='CKYDL2JM';reroute['placement:noobslab']='CKYDL5QM';reroute['placement:osboxes']='CKYDL5QW';reroute['placement:texblogorg']='CKYDL5QI';reroute['placement:vector4free']='CKYDL5QJ';reroute['placement:onlygfx']='CKYDL5QE';reroute['placement:developerdrive']='CKYDL537';reroute['placement:weandthecolor']='CKYDL53Y';reroute['placement:html5doctor']='CKYDL53U';reroute['placement:vectips']='CKYDL53N';reroute['placement:pydev']='CKYDL53M';reroute['placement:icons8com']='CKYITKQ7';reroute['placement:networktools']='CKYDL53I';reroute['placement:carlcheo']='CKYDL53L';reroute['placement:faqforge']='CKYITKQY';reroute['placement:digitalcom']='CKYITKQU';reroute['placement:designerdaily']='CKYITKQM';reroute['placement:creativenerds']='CKYITKJE';reroute['placement:inserthtml']='CKYITKQW';reroute['placement:go4expert']='CKYITKQI';reroute['placement:sanwebe']='CKYITKQL';reroute['placement:java4s']='CKYITKQJ';reroute['placement:spyrestudios']='CKYITKQE';reroute['placement:randomkeygen']='CKYITK37';reroute['placement:freewebtemplates']='CKYITK3Y';reroute['placement:photoshoplady']='CKYITK3U';reroute['placement:dreamcss']='CKYITK3N';reroute['placement:mygrafico']='CKYITK3M';reroute['placement:fromdev']='CKYITK3W';reroute['placement:queness']='CKYITK3I';reroute['placement:w3bin']='CKYITK3L';reroute['placement:psddd']='CKYITK3J';reroute['placement:webappers']='CKYITK3E';reroute['placement:icondeposit']='CKYDL5Q7';reroute['placement:cssplay']='CKYDL5QY';reroute['placement:snapmunk']='CKYDL5QU';reroute['placement:vecto2000']='CKYDL5QN';reroute['placement:cssmania']='CKYDL53W';reroute['placement:ctrlq']='CKYITKJJ';if(_bsa.isset(reroute[segment]))return reroute[segment];return zoneKey};var show_ads_via=false,cryptobar=['CKYDKKJJ','CKYDKKQJ','CKYDKKQM','CKYDKKQI','CKYDKKJE','CKYDKKQY','CKYDKKQE','CKYDKKJL','CKYDKKJW','CKYDEKQL','CKYDKKQW','CKYDKKQ7','CKYDKKJI','CKYDKKQL'];if(cryptobar.indexOf(zoneKey)>0)show_ads_via=true;if(zoneKey=='CKYDV2QM'||zoneKey=='C6ADVKE')zoneKey=temp_zonekey(segment);_bsa.fancybar.elID=function(options){return(options&&options.id)?options.id:'_fbn_'};function css(colors){var c=colors[0],backgroundColor=_bsa.isset(c)&&_bsa.isHex(c.barcolor)?c.barcolor:(_bsa.isset(c.backgroundColor)?c.backgroundColor:_bsa.testData.ads[0].backgroundColor),backgroundHoverColor=_bsa.isset(c)&&_bsa.isHex(c.barcolorHover)?c.barcolorHover:(_bsa.isset(c.backgroundHoverColor)?c.backgroundHoverColor:(_bsa.isset(c.backgroundHoverColor)?c.backgroundHoverColor:_bsa.testData.ads[0].backgroundHoverColor)),callToActionTextColor=_bsa.isset(c)&&_bsa.isHex(c.callToActionTextColor)?c.callToActionTextColor:(_bsa.isset(c.ctaTextColor)?c.ctaTextColor:_bsa.testData.ads[0].callToActionTextColor),callToActionTextColorHover=_bsa.isset(c)&&_bsa.isHex(c.callToActionTextColorHover)?c.callToActionTextColorHover:(_bsa.isset(c.ctaTextColorHover)?c.ctaTextColorHover:_bsa.testData.ads[0].callToActionTextColorHover),ctaBackgroundColor=_bsa.isset(c)&&_bsa.isHex(c.callToActionColor)?c.callToActionColor:(_bsa.isset(c.callToActionBackgroundColor)?c.callToActionBackgroundColor:(_bsa.isset(c.ctaBackgroundColor)?c.ctaBackgroundColor:_bsa.testData.ads[0].ctaBackgroundColor)),ctaBackgroundHoverColor=_bsa.isset(c)&&_bsa.isHex(c.callToActionColorHover)?c.callToActionColorHover:(_bsa.isset(c.ctaBackgroundHoverColor)?c.ctaBackgroundHoverColor:_bsa.testData.ads[0].ctaBackgroundHoverColor),textColor=_bsa.isset(c)&&_bsa.isHex(c.textcolor)?c.textcolor:(_bsa.isset(c.textColor)?c.textColor:_bsa.testData.ads[0].textColor),textColorHover=_bsa.isset(c)&&_bsa.isHex(c.textcolorHover)?c.textcolorHover:(_bsa.isset(c.textColorHover)?c.textColorHover:_bsa.testData.ads[0].textColorHover);return'<style type="text/css">._bsa_hide ._bsa_fancybar{top:-100%;}._bsa_show ._bsa_fancybar {top:0;}._bsa_fancybar{display:block;width:100%;float:left;position:fixed;top:-80px;left:0;right:0;z-index:100001;background-color:'+backgroundColor+';-webkit-transition:top 700ms;-moz-transition:top 700ms;-o-transition:top 700ms;transition:top 700ms;text-align:center;box-sizing:border-box;font-family:helvetica,arial,sans-serif;margin:0 auto;box-shadow: 0 1px 5px rgba(0,0,0,.6);backface-visibility:hidden;}._bsa_fancybar a {display:block;position:relative;text-align:left;text-decoration:none;margin:0 auto;float:left;width:100%;padding:10px 55px 10px 30px;box-sizing:border-box;}._bsa_fancybar a:hover {background:'+backgroundHoverColor+';display: block;}._bsa_fancybar a .fancybar-cta {display:block;float:right;color:'+callToActionTextColor+';background-color:'+ctaBackgroundColor+';border-radius:2px;line-height:28px;font-size:15px;box-sizing:border-box;margin:0;padding:0 12px;}._bsa_fancybar a:hover .fancybar-cta {background:'+ctaBackgroundHoverColor+';color:'+callToActionTextColorHover+';}._bsa_fancybar a .fancybar-logo {display:block;float:left;padding:0;margin:-10px 0;}._bsa_fancybar a .fancybar-logo img {display:block;max-width:110px;}._bsa_fancybar a .fancybar-text {float:left;font-size:16px;line-height:16px;padding:8px 0 0 15px;color:'+textColor+';}._bsa_fancybar a:hover .fancybar-text {color:'+textColorHover+';}@media all and (max-width:680px){body ._bsa_fancybar a{padding:5px 10% 5px 2%;}body ._bsa_fancybar a .fancybar-logo{margin:9px 1% 0 0;display:block;width:14%;}body ._bsa_fancybar a .fancybar-logo img {max-width:100%;display:block;margin:0 auto;}body ._bsa_fancybar a .fancybar-text{font-size:13px;line-height:13px;padding:10px 1% 10px 0;text-align:left;width:63%;display:block;}body ._bsa_fancybar a .fancybar-cta{display:block;width:20%;white-space:nowrap;margin:8px 0 0 0;box-sizing:border-box;text-align:center;}body ._bsa_fancybar .fancybar-close{right:10px;color:'+backgroundColor+';background:'+textColor+';margin:3px 0 0 0;}}._bsa_fancybar .fancybar-close{display:block;position:absolute;top:11px;right:15px;padding:6px 10px 8px;border-radius: 2px;color:'+textColor+';z-index:2;font-size:14px;line-height:12px;}._bsa_fancybar .fancybar-close:hover{cursor:pointer;background:'+backgroundHoverColor+';}@media all and (max-width:520px){body ._bsa_fancybar a .fancybar-logo{display:none;}body ._bsa_fancybar a .fancybar-cta{font-size:12px;width:36%;}}._bsa_fancybar a._bsa_ads_via{position:absolute;bottom:-24px;right:10px;display:block;width:98px;font-size:11px;color:#7e7e7e;padding:0;margin:0;text-align:right;background:rgba(255,255,255,.7);}</style>'}function template(ads){var a=ads[0],callToAction=(_bsa.isset(a.calltoaction)?a.calltoaction:(_bsa.isset(a.callToAction)?a.callToAction:a.cta)),company=_bsa.isset(a.heading)?a.heading:a.company,description=_bsa.isset(a.text)?a.text:a.description,image=_bsa.isset(a.base64)?a.base64:(_bsa.isset(a.image)?a.image:a.logo),logo=_bsa.isset(a.base64)?a.base64:(_bsa.isset(a.logo)?a.logo:a.image),statlink=_bsa.link(a.statlink,segment,custom_domain,a.timestamp),timestamp=a.timestamp,pixel=a.pixel,title=a.title,c='';c+='<div class="_bsa_fancybar">';if(show_ads_via&&!_bsa.isMobile())c+='<a href="https://www.buysellads.com/advertisers/cryptobar?utm_campaign=Cryptobar&utm_source=in_unit&utm_medium=cryptobar" target="_blank" class="_bsa_ads_via">&#9432; ads via cryptobar</a>';c+='<span class="fancybar-close" onclick="_bsa.close(\''+_bsa.fancybar.elID(options)+'\')">x</span><a href="'+statlink+'" target="_blank" rel="nofollow noopener"><span class="fancybar-logo"><img src="'+logo+'" /></span><span class="fancybar-cta">'+callToAction+'</span><span class="fancybar-text">'+description+'</span></a>';c+=_bsa.pixel(pixel,timestamp);c+='</div>';return c}if(!_bsa.getCookie(_bsa.fancybar.elID(options))){var _fancybar_didScroll;var _fancybar_didDrop=false;window.onscroll=function(){_fancybar_didScroll=true};var _fancybar_scrollInterval=setInterval(function(){if(_fancybar_didScroll&&!_bsa.getCookie(_bsa.fancybar.elID(options))){_fancybar_didScroll=false;var scrollTop=(window.pageYOffset!==undefined)?window.pageYOffset:(document.documentElement||document.body.parentNode||document.body).scrollTop;if(scrollTop>=100&&!document.getElementById(options.script_id)){_bsa.fancybar.readyToInit=true;_bsa.init('fancybar',zoneKey,segment,options)}else if(scrollTop>=100){_bsa.show(_bsa.fancybar.elID(options))}if(scrollTop<100){_bsa.hide(_bsa.fancybar.elID(options))}}},500)}if(ads){_bsa.drop((disable_css?'':css(ads))+template(ads),'body','div',_bsa.fancybar.elID(options));_bsa.clearQueue(_bsa.findInQueue(zoneKey))}};_bsa.fancybar.readyToInit=false;_fbn_placement=_bsa.getUrlVar(document.getElementById('_fancybar_js'),'placement');_bsa.init('fancybar','C6ADVKE','placement:'+_fbn_placement);