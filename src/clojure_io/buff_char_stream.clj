(ns clojure-io.buff-char-stream
  (:import (java.io FileReader FileWriter BufferedReader BufferedWriter)))


(defn copy-file [src tgt]
  (with-open [in (BufferedReader.(FileReader. src)) out (BufferedWriter. (FileWriter. tgt))]
    (loop [c (.read in)]
      (when (not (neg? c))
        (do (.write out c) (recur (.read in)))))))