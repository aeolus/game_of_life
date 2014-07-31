class ExpressiveRules extends spock.lang.Specification {
    def "dead cell rules test"() {
        def c = new Cell()

        expect:
        verifySurvive(aliveNeighbours, c) == survived

        where:
        aliveNeighbours | survived
        1               | false
        2               | false
        3               | true
        4               | false
        5               | false
        6               | false
        7               | false
        8               | false
    }

    def "alive cell rules test"() {
        def c = new Cell()
        c.seed()

        expect:
        verifySurvive(aliveNeighbours, c) == survived

        where:
        aliveNeighbours | survived
        1               | false
        2               | true
        3               | true
        4               | false
        5               | false
        6               | false
        7               | false
        8               | false
    }

    def verifySurvive(aliveNeighbours, cell) {
        cell.setNextState(aliveNeighbours)
        return cell.isSurvived()
    }
}
