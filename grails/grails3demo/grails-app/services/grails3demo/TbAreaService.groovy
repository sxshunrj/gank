package grails3demo

import grails.transaction.Transactional

@Transactional
class TbAreaService {

    def findByCode(code) {
        def area = TbArea.findByArea_code(code)
        println(area)
        area
    }
}
