(ns
  ^{:author abc}
  myfirstclj.views.layout
  (:require [hiccup.page :as h])
  )




(comment
  (defn common [title & body]
    (h/html5
      [:head [:meta {:charset "utf-8"}]
       [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
       [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
       [:title title]
       (h/include-css "/css/base.css"
         "/css/skeleton.css"
         "/css/screen.css")
       (h/include-css "http://fonts.googleapis.com/css?family=Sigmar+One&v1"
         "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")]
      [:body [:div {:id "header"}
              [:h1 {:class "container"} ""]]
       [:div {:id "content" :class "container"} body]]))
  )


;https://github.com/yokolet/hiccup-samples


  (defn application [title & content]
    (h/html5
      [:head [:meta {:charset "utf-8"}]
       [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
       [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
       [:title title]
       (h/include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")
       (h/include-js "http://code.angularjs.org/1.2.3/angular.min.js"
         "/js/ui-bootstrap-tpls.min.js"
         "/js/script.js")
       ]

      [:body
       [:div {:id "header"}
              [:h1 {:class "container"} "Abhishek Search..."]]
       [:div {:id "content" :class "container"} content]]))
