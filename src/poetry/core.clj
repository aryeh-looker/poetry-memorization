(ns poetry.core
  (:gen-class))

(defn check-line [line-expected]
    (let [line-observed (read-line)]
        (apply = (map clojure.string/trim (list line-expected line-observed)))))

(defn poetry
    "does poetry thing"
    [filepath]
	(let [file-contents (slurp filepath)]
		(let [file-split (clojure.string/split file-contents #"\n")]
			(doseq [line file-split]
				(while (not (check-line line)) (do
					(println line)))))))

(defn -main
    "This is a doc string"
    [& args]
    (if-let [filepath (first args)]
        (do
            (println (str "Opening: " filepath))
            (poetry filepath))
        (println "Please specify a filename!")))
