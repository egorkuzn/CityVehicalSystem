package ru.nsu.fit.g20204.egorkuzn.server.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.nsu.fit.g20204.egorkuzn.server.dao.editor.add.AddAuxiliaryModelDao
import ru.nsu.fit.g20204.egorkuzn.server.model.entity.editor.add.AddAuxiliaryModelEntity
import ru.nsu.fit.g20204.egorkuzn.server.service.AddEditorService

@Service
class AddEditorServiceImpl(
    @Autowired val addAuxiliaryModelDao: AddAuxiliaryModelDao
) : AddEditorService {
    override fun addAuxiliaryModel(list: List<AddAuxiliaryModelEntity>) = addAuxiliaryModelDao.sqlRun(list)
}