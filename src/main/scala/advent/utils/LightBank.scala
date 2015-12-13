package advent.utils

import scala.reflect.ClassTag

class LightBank[LightType:ClassTag](initialLightState: LightType,
                                    operations: Map[String, LightType => LightType],
                                    foldFunc: (Int, LightType) => Int) {

  private val lights = Array.fill(1000)(Array.fill(1000){initialLightState})

  private def opOnRange(x1: Int, y1: Int, x2: Int, y2: Int, op: LightType => LightType) =
    for (
      x <- Range.inclusive(List(x1, x2).min, List(x1, x2).max);
      y <- Range.inclusive(List(y1, y2).min, List(y1, y2).max)
    ) {
      lights(x)(y) = op(lights(x)(y))
    }

  def namedOpOnRange(x1: Int, y1: Int, x2: Int, y2: Int, op: String) =
    opOnRange(x1, y1, x2, y2, operations(op))

  def countLightState: Int = lights.flatten.foldLeft(0)(foldFunc)
}
