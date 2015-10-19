(ns clojure-io.char-stream
  (:import (java.io FileReader FileWriter)))

(defn copy-file [src tgt]
  (with-open [in (FileReader. src) out (FileWriter. tgt)]
    (loop [c (.read in)]
      (when (not (neg? c))
        (do (.write out c) (recur (.read in)))))))