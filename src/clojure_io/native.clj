(ns clojure-io.native
  (:require [clojure.java.io :as io]))

(defn copy-file [src tgt]
(io/copy (io/file src) (io/file tgt)))

(defn copy-file1 [src tgt]
  (io/copy (io/input-stream src) (io/output-stream tgt))) ;produces an empty file as output

(defn copy-file2 [src tgt] ; works only for text files
  (spit tgt (slurp src)))

;Use input-stream and output-stream to return a buffered Java InputSteam or OutputStream
(defn copy-file3 [src tgt] ; works with binary and text files. Buffered stream is used by default.
  (with-open [in (io/input-stream src) out (io/output-stream tgt)]
    (loop [c (.read in)]
      (when (not (neg? c))
        (do (.write out c) (recur (.read in)))))))

;Use reader and writer to return buffered Java Reader and Writer streams. Only works with text streams.
(defn copy-file4 [src tgt]
  (with-open [in (io/reader src) out (io/writer tgt)]
    (loop [c (.read in)]
      (when (not (neg? c))
        (do (.write out c) (recur (.read in)))))))



;clojure.java.io.file returns a java.io.File object (either a file or directory)
;you can use all the methods for java.io.File


