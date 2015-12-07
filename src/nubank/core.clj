
(ns nubank.core
  (:require [clojure.java.io :as io] ))


(def 	datafile (io/file (io/resource "edges.txt")))

(def 	edges [])

(defn 	not-equal [] (complement =))

(defn 	contem
		"Funcao que retorna se um numero x esta contido dentro de um vetor"
		([x y] 
			(if (= nil (some #(= x %) y)) false true)
		)
)


(defn 	search
		"Funcao que retorna um vetor com os vetores de ligacao de um no x"
		([x] [])
		([x y] (if (empty? y) (search x) 
					(if (contem x (y 0))  
						(conj (search (search x (subvec y 1)) x (subvec y 1)) (y 0))
						

						(search (search x (subvec y 1)) x (subvec y 1))	
					)
				)
		)
		([z x y] (if (empty? y) (search x y) z))
	)

(defn 	initEdges
		"Função que inicia o vetor Edges com os valores do txt"
		[]
		(with-open [rdr (io/reader datafile)]
			(doseq [line (line-seq rdr)]
				(def edges (conj edges 
						(into []	
							(map #(Integer. %) 
								(clojure.string/split line #" ")
							)
						)
					)
				)
			)
		)
	)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (initEdges)
  (println (search 2 edges))
  )
