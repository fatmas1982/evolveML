(ns
  ^{:author abc}
  myfirstclj.views.contents
  (:use [hiccup.form]
        [hiccup.element])
  (:require [myfirstclj.views.layout :as layout]
            [hiccup.form :as form]
            [hiccup.core :refer [h]]
            [ring.util.anti-forgery :as anti-forgery]))



;http://getbootstrap.com/css/
;http://www.bootply.com/96188
(defn betterUIuserform []
  [:div {:id "user-form" :class "sixteen columns alpha omega"}
   [:div {:class "row"}
    [:div {:class "col-lg-4"}
    [:form {:class "form-horizontal"}
     [:div {:class "form-group"}
      (label "name" "Search Something...")]
     [:div {:class "form-group"}
      (text-field {:class "form-control" :ng-model "yourName" :placeholder "Enter Any Search here"} "your-name")]
     [:div {:class "form-group"}
      (link-to {:type "submit" :class "btn btn-primary btn-lg"} "/" "Sign in")]

     ]]]])

(defn user-form []
  [:div {:id "user-form" :class "sixteen columns alpha omega"}
   (form/form-to [:post "/"]
                 (anti-forgery/anti-forgery-field)
                 (form/label "Test" "What do you want to ABHISHEK?")
                 (form/text-area "enter")
                 (form/submit-button "Press!"))])

;https://github.com/yokolet/hiccup-samples
;https://devcenter.heroku.com/articles/clojure-web-application
(defn index []
  (layout/application "Search..."
                      (betterUIuserform)
                      [:div {:class "clear"}]
                      ))

(defn not-found []
  [:div
   [:h1 {:class "info-worning"} "Page Not Found"]
   [:p "There's no requested page. "]
   (link-to {:class "btn btn-primary"} "/" "Take me to Home")])



(def names
  ["John" "Mary" "Watson" "James"])

;http://codepen.io/nikhil/pen/GxhcD
;http://stackoverflow.com/questions/4712645/using-compojure-hiccup-and-ring-to-upload-a-file
(defn search-item
  []
  [:div {:class "well"}
   [:h1 {:class "text-info"} "Hello Hiccup and AngularJS"]
   [:div {:class "row"}
    [:div {:class "col-lg-2"}
     (label "search" "Search...:")]
    [:div {:class "col-lg-4"}
    [:form {:class "searchbox" :action ""}
    [:input {:type "search" :placeholder "search..."}
     [:ul {:class "suggestions"}
      (for [name names]
        [:li name])
      ]]
     ]]]]
  )

(defn hello []
  [:div {:class "well"}
   [:h1 {:class "text-info"} "Hello Hiccup and AngularJS"]
   [:div {:class "row"}
    [:div {:class "col-lg-2"}
     (label "name" "Name:")]
    [:div {:class "col-lg-6"}
     (text-field {:class "form-control" :ng-model "yourName" :placeholder "Enter a name here"} "your-name")]]
   [:hr]
   [:h1 {:class "text-success"} "Hello {{yourName}}!"]])