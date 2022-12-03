package com.dyrelosh.pethotels.domain.companyusecase

import com.dyrelosh.pethotels.domain.companymodels.HotelAddsModel
import com.dyrelosh.pethotels.domain.companyrepository.HotelRepository

class GetAddUseCase (private val hotelRepository: HotelRepository) {
    suspend fun execute(token: String): List<HotelAddsModel>? {
        return hotelRepository.getAdds(token)
    }
}
//
//class GetTodosUseCase(private val todoRepository: TodoRepository) {
//    suspend fun execute(token: String): List<TodosModel>? {
//        return todoRepository.getTodos(token)
//    }
//}