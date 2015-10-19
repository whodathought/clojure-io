(ns clojure-io.core
  (:require [clojure-io.byte-stream :as bs]
            [clojure-io.char-stream :as cs]
            [clojure-io.char-ln-stream :as csl]
            [clojure-io.buff-char-stream :as bcs]
            [clojure-io.native :as native]
            [clojure-io.file-ops :as filo]))

(defn -main [choose]
  (let [choice (Integer. choose)]
  (cond
    (= 1 choice)
    (do (bs/copy-file "./source_files/clojure_logo.jpg" "./copied_files/logo2.jpg")
      (println "Binary file copied using byte stream"))
    (= 2 choice)
    (do (bs/copy-file "./source_files/xanadu.txt" "./copied_files/xanadu_bytes.txt")
        (println "Text file copied using byte stream"))
    (= 3 choice)
    (do (cs/copy-file "./source_files/xanadu.txt" "./copied_files/xanadu_char.txt")
        (println "Text file copied using character stream"))
    (= 4 choice)
    (do (csl/copy-file "./source_files/xanadu.txt" "./copied_files/xanadu_char_ln.txt")
        (println "Text file copied line by line using character stream"))
    (= 5 choice)
    (do (bcs/copy-file "./source_files/xanadu.txt" "./copied_files/xanadu_char.txt")
        (println "Text file copied using buffered character stream"))
    (= 6 choice)
    (do (native/copy-file "./source_files/clojure_logo.jpg" "./copied_files/logo2.jpg")
        (println "Binary file copied using clojure.java.io copy function"))
    (= 7 choice)
    (do (native/copy-file "./source_files/xanadu.txt" "./copied_files/xanadu_copy.txt")
        (println "Text file copied using clojure.java.io copy function"))
    (= 8 choice)
    (do (native/copy-file1 "./source_files/xanadu.txt" "./copied_files/xanadu_copy_stream.txt")
        (println "Text file copied using clojure.java.io copy function"))
    (= 9 choice)
    (do (native/copy-file2 "./source_files/xanadu.txt" "./copied_files/xanadu_spit.txt")
        (println "Text file copied using spit and slurp functions"))
    (= 10 choice)
    (do (native/copy-file2 "./source_files/clojure_logo.jpg" "./copied_files/clojure_logo_spat.jpg")
        (println "Binary file copied using spit and slurp functions")) ;results in corrupted file
    (= 11 choice)
    (do (native/copy-file3 "./source_files/xanadu.txt" "./copied_files/xanadu_io.txt")
        (println "Text file copied using clojure.java.io"))
    (= 12 choice)
    (do (native/copy-file3 "./source_files/clojure_logo.jpg" "./copied_files/clojure_logo_io.jpg")
        (println "Binary file copied using clojure.java.io input-stream and output-stream"))
    (= 13 choice)
    (do (native/copy-file4 "./source_files/xanadu.txt" "./copied_files/xanadu_iorw.txt")
        (println "Text file copied using clojure.java.io reader and writer"))
    (= 14 choice)
    (do (native/copy-file4 "./source_files/clojure_logo.jpg" "./copied_files/clojure_logo_iorw.jpg")
        (println "Binary file copied using clojure.java.io reader and writer")) ;results in corrupted file
    (= 15 choice)
    (do (native/copy-file "./source_files/parentDirectory" "./copied_files/copiedDirectory")
        (println "Directory copied using clojure.java.io copy function"))
    (= 16 choice)
    (do (filo/copy-all "./source_files/parentDirectory" "./copied_files/parentDirectory")
        (println "directory copying"))


    :else (println "No function selected. Enter \"lein run x\" where x is the integer corresponding to a chosen function."))))
