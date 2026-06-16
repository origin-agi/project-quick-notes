package com.origin.idea

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.content.ContentFactory
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.BorderFactory
import javax.swing.JButton

class MyToolWindowFactory : ToolWindowFactory {
    override fun shouldBeAvailable(project: Project) = true

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val projectQuickNotes = ProjectQuickNotesToolWindow(project)
        val content = ContentFactory.getInstance().createContent(projectQuickNotes.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    class ProjectQuickNotesToolWindow(project: Project) {
        private val properties = PropertiesComponent.getInstance(project)
        private val noteEditor = JBTextArea(12, 40).apply {
            text = properties.getValue(NOTE_KEY, "")
            lineWrap = true
            wrapStyleWord = true
        }
        private val statusLabel = JBLabel(MyMessageBundle.message("toolwindow.ProjectQuickNotes.status.ready"))

        private val content = JBPanel<JBPanel<*>>(BorderLayout(0, 8)).apply {
            border = BorderFactory.createEmptyBorder(12, 12, 12, 12)

            add(JBLabel(MyMessageBundle.message("toolwindow.ProjectQuickNotes.title")), BorderLayout.NORTH)
            add(JBScrollPane(noteEditor), BorderLayout.CENTER)
            add(createFooter(), BorderLayout.SOUTH)
        }

        fun getContent(): JBPanel<JBPanel<*>> = content

        private fun createFooter() = JBPanel<JBPanel<*>>(BorderLayout()).apply {
            add(statusLabel, BorderLayout.CENTER)
            add(JBPanel<JBPanel<*>>(FlowLayout(FlowLayout.RIGHT, 8, 0)).apply {
                add(JButton(MyMessageBundle.message("toolwindow.ProjectQuickNotes.clear.button")).apply {
                    addActionListener {
                        noteEditor.text = ""
                        properties.unsetValue(NOTE_KEY)
                        statusLabel.text = MyMessageBundle.message("toolwindow.ProjectQuickNotes.status.cleared")
                    }
                })
                add(JButton(MyMessageBundle.message("toolwindow.ProjectQuickNotes.save.button")).apply {
                    addActionListener {
                        properties.setValue(NOTE_KEY, noteEditor.text)
                        statusLabel.text = MyMessageBundle.message(
                            "toolwindow.ProjectQuickNotes.status.saved",
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                        )
                    }
                })
            }, BorderLayout.EAST)
        }

        companion object {
            private const val NOTE_KEY = "com.origin.idea.projectQuickNotes.note"
        }
    }
}
