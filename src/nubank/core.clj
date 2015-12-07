(ns nubank.core
  (:require [clojure.java.io :as io] ))


(def 	datafile (io/file (io/resource "edges.txt")))

(def 	edges [])

(defn 	teste
		"aa"
		[]
		(with-open [rdr (io/reader datafile)]
			(doseq [line (line-seq rdr)]
				(def edges (conj edges (clojure.string/split line #" ")))
			)
		)
	)

;(defn 	readFile
;		"função para ler o arquivo edge"
;		[]
;		(
;			with-open [rdr (reader "edges.txt")]
 ; 				(doseq [line (line-seq rdr)]
  ;  				(println line))
	;	)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (teste)
  (println edges)
  )
