(ns clojure-io.char-ln-stream
(:import (java.io FileReader FileWriter BufferedReader PrintWriter)))

(defn copy-file [src tgt]
  (with-open [in (BufferedReader. (FileReader. src)) out (PrintWriter. (FileWriter. tgt))]
    (loop [ln (.readLine in)]
      (when (not (nil? ln))
        (do (.println out ln) (recur (.readLine in)))))))