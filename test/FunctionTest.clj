 (ns FunctionTest)

 ;;reference http://www.braveclojure.com/core-functions-in-depth/

(println "Test Function")

(defn testMap
 [input]
 (str input " Hi hru?"))

(println "Seq can be treated as Seq " (map testMap ["Abhishek " "Buntha"]))
(println "Seq can be treated as Seq " (map testMap ))
(println "Exact map use-case "
       (into {} (map (fn
                   [[key value]]
                   [key (inc value)])
                  {:name 1 :value 1}))
       )

(println "Convert map to Sequence "(map identity {:name "Abhishek" :value "Buntha"}))
(println "map inside collection " (map str ["a" "b" "c"] ["d" ["e" "f"] "g" "h"] ))

(def sum
 #(reduce + %))

(def divide
 #(/ (sum %) (count %) )
 )

(defn stats
 [numbers]
 (map #(% numbers) [sum count divide])
 )

(println "map as a function 1 " (stats [1 2 3 4 5]))
(println "map as a function 2 " (stats [10 3 40]))


(println "REDUCE " (reduce (fn
                             [map-value [key value]]
                             (if (> value 4)
                               (assoc map-value key value)
                               map-value))
                           {}
                           {:A 9 :B 10 :c 3.9 :d 4.1 :e 2.2 :f 8.9 :g 4}
                           ))

 ;;test take-while

(def food-journal
  [{:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}
   {:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   ])


(println "take-while test " (take-while #(> (:month %) 3) food-journal) )

(println "take-while & drop-while " (take-while #(= (:month %) 1)  (drop-while #(> (:month %) 3) food-journal)  ) )

(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))