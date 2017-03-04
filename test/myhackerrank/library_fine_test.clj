(ns myhackerrank.library_fine_test
  (:require [clojure.test :refer :all]
            [myhackerrank.library_fine :refer :all]))

(deftest library-fine-tests
  (is (= 45 (library-fine 9 6 2015 6 6 2015))))
