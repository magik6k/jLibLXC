package net.magik6k.jliblxc

import java.io.{OutputStream, InputStream, IOException}

object CopyUtil {
  def use[T <: { def close(): Unit }](closable: T)(block: T => Unit) {
    try {
      block(closable)
    }
    finally {
      closable.close()
    }
  }

  @throws(classOf[IOException])
  def copy(from: InputStream, to: OutputStream) {
    use(from) { in =>
      use(to) { out =>
        val buffer = new Array[Byte](1024)
        Iterator.continually(in.read(buffer))
          .takeWhile(_ != -1)
          .foreach { out.write(buffer, 0 , _) }
      }
    }
  }
}
