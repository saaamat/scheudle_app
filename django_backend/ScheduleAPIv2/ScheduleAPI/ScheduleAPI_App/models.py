from django.db import models


class Descriptions(models.Model):
    name = models.ForeignKey('Names', models.DO_NOTHING, db_column='name')
    description = models.CharField(max_length=255)
    index = models.SmallIntegerField()

    class Meta:
        managed = False
        db_table = 'descriptions'


class Events(models.Model):
    start_time = models.DateTimeField()
    end_time = models.DateTimeField()
    subject_name = models.CharField(max_length=255)
    location = models.CharField(max_length=255)
    instructors = models.CharField(max_length=255)
    event_type = models.CharField(max_length=255)
    subject_name_short = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'events'


class Names(models.Model):
    name = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'names'


class Profiles(models.Model):
    name = models.CharField(max_length=255, blank=True, null=True)
    index = models.SmallIntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'profiles'


class ProfilesEvents(models.Model):
    profile = models.ForeignKey(Profiles, models.DO_NOTHING, db_column='profile')
    event = models.ForeignKey(Events, models.DO_NOTHING, db_column='event')

    class Meta:
        managed = False
        db_table = 'profiles_events'