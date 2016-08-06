package pro.zackpollard.telegrambot.api.menu;

public class SubInlineMenuBuilder extends AbstractInlineMenuBuilder<SubInlineMenuBuilder> {
    private InlineMenuBuilder builder;

    SubInlineMenuBuilder(InlineMenuBuilder builder) {
        this.builder = builder;
    }

    @Override
    protected SubInlineMenuBuilder instance() {
        return this;
    }

    public InlineMenu build() {
        InlineMenu menu = buildMenu(null);

        builder.subs.add(menu);
        return menu;
    }
}
