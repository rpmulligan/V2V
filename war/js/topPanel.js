$(document)
    .ready(
        function() {

          var tabs = $("#topPanelTabs").tabs({cache: false});
//          // For forward and back
//          $.address.externalChange(function(event){
//            console.log("here");
//            $("#topPanelTabs").tabs( "select" , window.location.hash )
//          });
//
//          // when the tab is selected update the url with the hash
//          $("#topPanelTabs").bind("tabsselect", function(event, ui) { 
//            window.location.hash = ui.tab.hash;
//          });
//          var tabEvent = false,
//              initialTab = 'homeLandingPageContent',
//              navSelector = '#topPanelTabs .ui-tabs-nav',
//              navFilter = function(el) {
//                            return $(el).attr('href').replace(/^#/, '');
//                          },
//              panelSelector = '#topPanelTabs .ui-tabs-panel',
//              panelFilter = function() {
//                              $(panelSelector + ' a').filter(
//                                    function() {
//                                       return $(navSelector + ' a[title=' + $(this).attr('title') + ']').size() != 0;
//                                    }).each(
//                                         function(event) {
//                                           $(this).attr('href', '#' + $(this).attr('title').replace(/ /g, '_'));
//                                         });
//                            };
//
//          // Initializes plugin features
//          $.address.strict(false).wrap(true);
//
//          if ($.address.value() == '') {
//            $.address.history(false).value(initialTab).history(true);
//          }
//
//          // Address handler
//          $.address.init(function(event) {
//
//            // Adds the ID in a lazy manner to prevent scrolling
//            $(panelSelector).attr('id', initialTab);
//
//            // Enables the plugin for all the content links
//            $(panelSelector + ' a').address(function() {
//              return navFilter(this);
//            });
//
//            panelFilter();
//
//           // Tabs setup
//            tabs = $('#topPanelTabs').tabs({
//              cache : false,
//              load : function(event, ui) {
//                // Filters the content and applies the plugin if needed
//                $(ui.panel).html($(panelSelector, ui.panel).html());
//                panelFilter();
//              },
//              fx : {
//                opacity : 'toggle',
//                duration : 'fast'
//              }
//            }).css('display', 'block');
//
//            // Enables the plugin for all the tabs
//            $(navSelector + ' a').click(function(event) {
//              tabEvent = true;
//              $.address.value(navFilter(event.target));
//              tabEvent = false;
//              return false;
//            });
//
//          }).change(
//              function(event) {
//
//                var current = $('a[href=#' + event.value + ']:first');
//                console.log(current);
//                // Sets the page title
//                $.address.title($.address.title().split(' | ')[0] + ' | '
//                    + current.text());
//
//                // Selects the proper tab
//                if (!tabEvent) {
//                  tabs.tabs('select', current.attr('href'));
//                }
//
//              });
//          
//           // Hides the tabs during initialization
//           document.write('<style type="text/css"> #topPanelTabs { display: none; }</style>');

          $(".leftPanel").tabs(
              {
                cache : false,
                ajaxOptions : {
                  cache : false,
                  error : function(xhr, status, index, anchor) {
                    $(anchor.hash).html(
                        "Oops ... There was an error "
                            + "loading this tab. Please try "
                            + "again in a while. If the problem "
                            + "persists report an Issue.");
                  }
                }
              });

        });
