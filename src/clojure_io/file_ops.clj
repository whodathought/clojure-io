(ns clojure-io.file-ops
  (:require [clojure.java.io :as io]
            [clojure.string :as st]))

(defn- copy-dir
  "copies the directory structure to the target location"
  [src-dir tgt-dir]
  (doseq [d
          (map #(st/replace-first % src-dir tgt-dir) ;replace the first occurance of the source directory with the target directory
               (map #(.getPath %) ;convert the objects in the sequence to path strings
                    (filter #(.isDirectory %) ;filter the sequence to directories only
                            (file-seq (io/file src-dir)))))] ;generate a sequence of the file / directory structure
    (.mkdirs (io/file d)))) ;use doseq to create each directory in the sequence



(defn- copy-files
  "copies the files to the target location"
  [src tgt]
  (doseq [f
          (map #(.getPath %) ;convert the objects in the sequence to path strings
               (filter #(.isFile %) ;filter the sequence to files only
                  (file-seq (io/file src))))] ;generate a sequence of the file / directory structure
    (io/copy (io/file f) ;use doseq to copy each file in the sequence
             (io/file (st/replace-first f src tgt))))) ;output file path by replacing src directory with tgt directory

(defn copy-all [src tgt]
  (copy-dir src tgt)
  (copy-files src tgt))