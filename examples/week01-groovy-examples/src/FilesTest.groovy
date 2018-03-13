class FilesTest extends GroovyTestCase {
    void testFiles() {
        File f = new File("nonexistent.file")
        f.metaClass {
            exists { -> true }
            getAbsolutePath { -> "/opt/some/dir/${delegate.name}" }
            isFile { -> true }
            getText { -> "This is the text in the file." }
        }

        assertTrue f.exists()
        assertTrue f.isFile()
        assertEquals "/opt/some/dir/nonexistent.file", f.absolutePath
        assertTrue f.text.startsWith("This is")
    }
}
