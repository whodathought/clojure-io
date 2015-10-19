(ns clojure-io.byte-stream
(:import (java.io FileInputStream FileOutputStream )))

(defn copy-file [src tgt]
  (with-open [in (FileInputStream. src) out (FileOutputStream. tgt)]
    (loop [b (.read in)]
      (when (not (neg? b))
        (do (.write out b) (recur (.read in)))))))