package butterknife.compiler;

import com.squareup.javapoet.CodeBlock;
import javax.annotation.Nullable;

interface ResourceBinding {
  Id id();

  /** True if the code for this binding requires a 'res' variable for {@code Resources} access. */
  boolean requiresResources(int sdk);

  CodeBlock render(int sdk);
}
