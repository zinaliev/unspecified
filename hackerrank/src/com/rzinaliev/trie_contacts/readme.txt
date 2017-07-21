Solution_FastTrie:
- is only one passed all tests on HackerRank
- increments count on add() method, so find() runs fast

Solution_SlowTrie:
- had a plenty of TimedOut failures
- uses recursive search of leaves on find() method

Solution_HashMap:
- uses Map<String, Integer> to store count of each sub-word
- surprisingly didn't pass a couple of tests on HackerRank because of TimedOut failures